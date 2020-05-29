package com.els.runhe.product.web.controller.product;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.runhe.product.entity.product.ProductImg;
import com.els.runhe.product.entity.product.ProductImgExample;
import com.els.runhe.product.entity.productPoint.ProductPoint;
import com.els.runhe.product.entity.productPoint.ProductPointExample;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;
import com.els.runhe.product.service.product.ProductImgService;
import com.els.runhe.product.service.product.ProductService;
import com.els.runhe.product.service.productPoint.ProductPointService;
import com.els.runhe.product.service.productPrice.ProductPriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "产品")
@Controller
@RequestMapping("product")
public class ProductController {
	@Resource
	protected ProductService productService;

	@Resource
	protected ProductPriceService productPriceService;

	@Resource
	protected ProductImgService productImgService;

	@Resource
	protected ProductPointService productPointService;

	@ApiIgnore
	@RequestMapping("service/toAddView")
	public ModelAndView toAddView() {
		return new ModelAndView("product/product/toAddView");
	}

	@ApiIgnore
	@RequestMapping("service/toMainView")
	public ModelAndView toMainView() {
		return new ModelAndView("product/product/toMainView");
	}

	@ApiIgnore
	@RequestMapping("service/toUpdateViewById")
	public ModelAndView toUpdateViewById(int id) throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
		ModelAndView view = new ModelAndView();
		Product product = this.productService.queryObjById(id);
		view.addObject("product", product);

		ProductPriceExample priceExample = new ProductPriceExample();
		ProductPriceExample.Criteria criteria = priceExample.createCriteria();
		criteria.andProductIdEqualTo(id);
//		criteria.andProductIdEqualTo(id).andTypeEqualTo(ProductScene.TYPE_DEFAULT);
//		criteria.andprid
		List<ProductPrice> priceList = this.productPriceService.queryAllObjByExample(priceExample);

		ProductImgExample imgExample = new ProductImgExample();
		ProductImgExample.Criteria criteria1 = imgExample.createCriteria();
		criteria1.andProductIdEqualTo(id);
		List<ProductImg> imgList = this.productImgService.queryAllObjByExample(imgExample);

		ProductPointExample pointExample = new ProductPointExample();
		ProductPointExample.Criteria criteria2 = pointExample.createCriteria();
		criteria2.andProductIdEqualTo(id);
		List<ProductPoint> pointList = this.productPointService.queryAllObjByExample(pointExample);
		ProductPoint point = null;
		if(pointList.size() >0 ){
			point = pointList.get(0);
		}

//        List<ProductPrice> plusPriceList = this.productPriceService.findProductPriceByScene(ProductScene.METRX_GIFT_MALL,id, 1);
//        if(plusPriceList.size() > 0){
//            point.setPlusPrice(plusPriceList.get(0).getValue());
//            point.setPriceId(plusPriceList.get(0).getId());
//
//        }

		view.addObject("priceList",priceList);
		view.addObject("point",point);
		view.addObject("imgList",imgList);
		view.setViewName("product/product/toAddView");
		return view;
	}

	@ApiOperation(httpMethod = "POST", value = "创建产品")
	@RequestMapping(value={"service/create","front/create"})
	@ResponseBody
	public ResponseResult<Product> create(@RequestBody Product product) {
//		Integer storeid = StoreUtils.getStoreFromThreadLocal().getId();
//		product.setStoreId(storeid);
		this.productService.addObj(product);
		return ResponseResult.success(product);
	}

	@ApiOperation(httpMethod = "POST", value = "编辑产品")
	@RequestMapping(value={"service/edit","front/edit"})
	@ResponseBody
	public ResponseResult<Product> edit(@RequestBody Product product) {
		if (product.getId() == null || product.getId() <= 0) {
			throw new CommonException("id 为空，保存失败");
		}
		this.productService.modifyObj(product);
		return ResponseResult.success(product);
	}

	@ApiOperation(httpMethod = "POST", value = "删除产品")
	@RequestMapping(value={"service/deleteById","front/deleteById"})
	@ResponseBody
	public ResponseResult<String> deleteById(int id) {
		this.productService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "根据条件查询产品")
	@ApiImplicitParams({
			@ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),
			@ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),
			@ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Product", paramType = "body", dataType = "QueryParamWapper" ),
			@ApiImplicitParam( name = "categoryId", required = false, value = "分类id", paramType = "query", dataType = "string" )
	})
	@RequestMapping(value={"service/findByPage","front/findByPage"})
	@ResponseBody
	public ResponseResult<PageView<Product>> findByPage(
			@RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestBody(required=false) QueryParamWapper wapper,
			Integer categoryId) {

		ProductExample example = new ProductExample();
		example.setPageView(new PageView<Product>(pageNo, pageSize));

		ProductExample.Criteria criteria = example.createCriteria();
		if(wapper != null){
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		example.setOrderByClause("sequence DESC, update_time DESC");
		return ResponseResult.success(this.productService.findConditionByPage(example, categoryId));
	}

	
	/*@RequestMapping("front/findConditionByPage")
	@ResponseBody
	public ResponseResult<PageView<Product>> findConditionByPage(
			@RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestBody(required=false) QueryParamWapper wapper ) {

		ProductExample example = new ProductExample();
		example.setPageView(new PageView<Product>(pageNo, pageSize));
		
		ProductExample.Criteria criteria = example.createCriteria();
		if(wapper != null){
			CriteriaUtils.addCriterion(criteria, wapper);
		}
		criteria.andSaleStatusEqualTo(Constant.YES_INT);
		return ResponseResult.success(this.productService.queryObjByPage(example));
		
	}*/

	@ApiOperation(httpMethod = "GET", value = "查询产品详情")
	@RequestMapping("front/findDetailById")
	@ResponseBody
	public ResponseResult<Product> findDetailById(@ApiParam("产品id") int id,@RequestParam(required = true) String sceneCode) {
		Product product = this.productService.queryProductDetailById(sceneCode, id);
		return ResponseResult.success(product);
	}

}