package com.els.runhe.product.web.controller.product;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.runhe.product.entity.product.ProductImg;
import com.els.runhe.product.entity.product.ProductImgExample;
import com.els.runhe.product.service.product.ProductImgService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="产品图片")
@Controller
@RequestMapping("productImg")
public class ProductImgController {
    @Resource
    protected ProductImgService productImgService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("productImg/productImg/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("productImg/productImg/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        ProductImg productImg = this.productImgService.queryObjById(id);
        view.addObject("productImg", productImg);
        view.setViewName("productImg/productImg/toAddView");
        return view;
    }

    @ApiIgnore
    @ApiOperation(httpMethod="POST", value="创建产品图片")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ProductImg productImg) {
        this.productImgService.addObj(productImg);
        return ResponseResult.success();
    }

    @ApiIgnore
    @ApiOperation(httpMethod="POST", value="编辑产品图片")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ProductImg productImg) {
        if (productImg.getId() == null || productImg.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.productImgService.modifyObj(productImg);
        return ResponseResult.success();
    }

    @ApiIgnore
    @ApiOperation(httpMethod="POST", value="删除产品图片")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.productImgService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiIgnore
    @ApiOperation(httpMethod="GET", value="查询产品图片")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<ProductImg>> findByPage(
    		@ApiParam(value="分页索引",defaultValue="1") @RequestParam(defaultValue="0") int pageNo, 
    		@ApiParam(value="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize, 
    		@ApiParam(value="查询条件") String sSearch) {
        PageView<ProductImg> pageView = new PageView<>(pageNo, pageSize);
        ProductImgExample example = new ProductImgExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        return ResponseResult.success(this.productImgService.queryObjByPage(example));
    }

    @ApiIgnore
    @ApiOperation(httpMethod="POST", value="批量创建多张图片")
    @RequestMapping("service/createOrEditImgs")
    @ResponseBody
    public ResponseResult<String> createOrEditImgs(@RequestBody List<ProductImg> productImg) {
    	if (CollectionUtils.isEmpty(productImg)) {
			throw new CommonException("产品图片为空无法保存");
		}
    	
    	for(ProductImg img : productImg){
    		if (img.getProductId() == null || img.getProductId() <=0) {
    			throw new CommonException("产品id为空无法保存");
			}
    		if (StringUtils.isBlank(img.getUrl())) {
    			throw new CommonException("产品url为空无法保存");
    		}
    	}
    	
    	for(ProductImg img : productImg){
    		this.productImgService.addObj(img);
    	}
        return ResponseResult.success();
    }

    @ApiIgnore
    @ApiOperation(httpMethod="GET", value="查询产品的所有图片")
    @RequestMapping("service/findAll")
    @ResponseBody
    public List<ProductImg> findAll(Integer id) {
        if (id !=null) {
            ProductImgExample example = new ProductImgExample();
            ProductImgExample.Criteria criteria = example.createCriteria();
            criteria.andProductIdEqualTo(id);
            return this.productImgService.queryAllObjByExample(example);
        }
       return null;
    }
}