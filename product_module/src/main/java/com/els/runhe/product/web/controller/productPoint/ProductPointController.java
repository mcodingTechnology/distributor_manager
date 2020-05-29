package com.els.runhe.product.web.controller.productPoint;

import com.els.runhe.product.entity.productPoint.ProductPoint;
import com.els.runhe.product.entity.productPoint.ProductPointExample;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;
import com.els.runhe.product.entity.productScene.ProductScene;
import com.els.runhe.product.entity.productScene.ProductSceneExample;
import com.els.runhe.product.service.productPoint.ProductPointService;
import com.els.runhe.product.service.productPrice.ProductPriceService;
import com.els.runhe.product.service.productScene.ProductSceneService;
import com.els.runhe.product.utils.ProductSceneEnum;
import com.els.base.core.exception.CommonException;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.PageView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="产品积分")
@Controller
@RequestMapping("productPoint")
public class ProductPointController {
    @Resource
    protected ProductPointService productPointService;
    @Resource
    protected ProductPriceService productPriceService;
    @Resource
    protected ProductSceneService productSceneService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("wechat/productPoint/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("wechat/productPoint/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        ProductPoint productPoint = this.productPointService.queryObjById(id);
        view.addObject("productPoint", productPoint);
        view.setViewName("wechat/productPoint/toAddView");
        return view;
    }

    @ApiOperation(httpMethod="POST", value="创建产品积分")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ProductPoint productPoint) {
        /*if(productPoint.getPlusPrice()!=null){
            
        	ProductSceneExample example = new ProductSceneExample();
            ProductSceneExample.Criteria criteria = example.createCriteria();
            criteria.andCodeEqualTo(ProductSceneEnum.GIFT_MALL.getCode());

            List<ProductScene> list = this.productSceneService.queryAllObjByExample(example);
            ProductPrice price = new ProductPrice();
            price.setValue(productPoint.getPlusPrice());
            price.setProductId(productPoint.getProductId());
            this.productPriceService.addObj(price,list.get(0));
        }
        this.productPointService.addObj(productPoint);*/
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑产品积分")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ProductPoint productPoint) {
        /*if (productPoint.getId() == null || productPoint.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        if(productPoint.getPlusPrice()!=null){
            ProductSceneExample example = new ProductSceneExample();
            ProductSceneExample.Criteria criteria = example.createCriteria();
            criteria.andCodeEqualTo(ProductSceneEnum.GIFT_MALL.getCode());

            List<ProductScene> list = this.productSceneService.queryAllObjByExample(example);

            ProductPriceExample productPriceExample = new ProductPriceExample();
            ProductPriceExample.Criteria cri = productPriceExample.createCriteria();
            cri.andSceneIdEqualTo(list.get(0).getId()).andProductIdEqualTo(productPoint.getProductId());
            List<ProductPrice> tmpList = this.productPriceService.queryAllObjByExample(productPriceExample);

            ProductPrice price = new ProductPrice();
            price.setId(productPoint.getPriceId());
            price.setValue(productPoint.getPlusPrice());
            if(tmpList.size() >0){
                this.productPriceService.modifyObj(price);
            }else{
                price.setProductId(productPoint.getProductId());
                this.productPriceService.addObj(price, list.get(0));
            }
        }
        this.productPointService.modifyObj(productPoint);*/
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除产品积分")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.productPointService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="查询产品积分")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<ProductPoint>> findByPage(@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="1") int pageNo, @ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize, @ApiParam(value="查询条件") String sSearch) {
        PageView<ProductPoint> pageView = new PageView<>(pageNo, pageSize);
        ProductPointExample example = new ProductPointExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        return ResponseResult.success(this.productPointService.queryObjByPage(example));
    }
}