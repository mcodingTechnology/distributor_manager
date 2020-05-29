package com.els.runhe.product.web.controller.productCategoryRef;

import com.els.runhe.product.entity.category.ProductCategory;
import com.els.runhe.product.entity.category.ProductCategoryExample;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRef;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRefExample;
import com.els.runhe.product.service.productCategoryRef.ProductCategoryRefService;
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

@Api(value="产品-分类-关联")
@Controller
@RequestMapping("productCategoryRef")
public class ProductCategoryRefController {
    @Resource
    protected ProductCategoryRefService productCategoryRefService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("sns/productCategoryRef/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("sns/productCategoryRef/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        ProductCategoryRef productCategoryRef = this.productCategoryRefService.queryObjById(id);
        view.addObject("productCategoryRef", productCategoryRef);
        view.setViewName("sns/productCategoryRef/toAddView");
        return view;
    }

    @ApiOperation(httpMethod="POST", value="创建产品-分类-关联")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ProductCategoryRef productCategoryRef) {
        this.productCategoryRefService.addObj(productCategoryRef);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑产品-分类-关联")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ProductCategoryRef productCategoryRef) {
        if (productCategoryRef.getId() == null || productCategoryRef.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.productCategoryRefService.modifyObj(productCategoryRef);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除产品-分类-关联")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.productCategoryRefService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="查询产品-分类-关联")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<ProductCategoryRef>> findByPage(
    		@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="1") int pageNo, 
    		@ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize, 
    		@ApiParam(value="查询条件") String sSearch) {
        PageView<ProductCategoryRef> pageView = new PageView<>(pageNo, pageSize);
        ProductCategoryRefExample example = new ProductCategoryRefExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        return ResponseResult.success(this.productCategoryRefService.queryObjByPage(example));
    }

    @ApiOperation(httpMethod="GET", value="按条件查询产品-分类-关联")
    @RequestMapping("service/findByCategoryId")
    @ResponseBody
    public List<ProductCategoryRef> findByCategoryId(Integer categoryId) {
        ProductCategoryRefExample example = new ProductCategoryRefExample();
        ProductCategoryRefExample.Criteria criteria = example.createCriteria();
        if(categoryId !=null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        return this.productCategoryRefService.queryAllObjByExample(example);
    }
}