package com.els.runhe.product.web.controller.category;

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
import com.els.runhe.product.entity.category.ProductCategory;
import com.els.runhe.product.entity.category.ProductCategoryExample;
import com.els.runhe.product.service.category.ProductCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="产品分类")
@Controller
@RequestMapping("productCategory")
public class ProductCategoryController {
    @Resource
    protected ProductCategoryService productCategoryService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("product/productCategory/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("product/productCategory/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        ProductCategory productCategory = this.productCategoryService.queryObjById(id);
        view.addObject("productCategory", productCategory);
        view.setViewName("product/productCategory/toAddView");
        return view;
    }

    @ApiOperation(httpMethod="POST", value="创建产品分类")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ProductCategory productCategory) {
        this.productCategoryService.addObj(productCategory);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑产品分类")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ProductCategory productCategory) {
        if (productCategory.getId() == null || productCategory.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.productCategoryService.modifyObj(productCategory);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除产品分类")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.productCategoryService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="查询产品分类")
    @ApiImplicitParams({ 
	    @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	    @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	    @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ProductCategory", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(value={"service/findByPage","front/findByPage"})
    @ResponseBody
    public ResponseResult<PageView<ProductCategory>> findByPage(
            @RequestParam(defaultValue="1") int pageNo,
            @RequestParam(defaultValue="10") int pageSize,
            @RequestBody(required=false) QueryParamWapper wapper) {
        ProductCategoryExample example = new ProductCategoryExample();
        example.setPageView(new PageView<ProductCategory>(pageNo, pageSize));

        ProductCategoryExample.Criteria criteria = example.createCriteria();
        if(wapper != null){
			CriteriaUtils.addCriterion(criteria, wapper);
		}
        return ResponseResult.success(this.productCategoryService.queryObjByPage(example));
    }

    @ApiOperation(httpMethod = "GET", value="根据parentid查询产品分类")
    @RequestMapping("service/findByParentId")
    @ResponseBody
    public ResponseResult<List<ProductCategory>> findByParentId(int categoryParentId){
        
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryParentIdEqualTo(categoryParentId);
//        criteria.andStoreIdEqualTo(StoreUtils.getStoreFromThreadLocal().getId());
        return ResponseResult.success(this.productCategoryService.queryAllObjByExample(example));
    }
    
    @RequestMapping("service/findByParentAndChildren")
    @ResponseBody
    public ResponseResult<ProductCategory> findByParentAndChildren(@RequestParam(defaultValue="0") int topParentId){
    	return ResponseResult.success(this.productCategoryService.queryObjById(topParentId));
    }

//    @ApiOperation(httpMethod = "GET", value="查询所有分类与对应的子类")
//    @RequestMapping("service/findByParentAndChildren")
//    @ResponseBody
//    public ResponseResult<List<Map<String,Object>>> findByParentAndChildren(){
//        ResponseResult<List<Map<String,Object>>> result = new ResponseResult<List<Map<String,Object>>>();
//        Integer storeid =  StoreUtils.getStoreFromThreadLocal().getId();
//
//        ProductCategoryExample example = new ProductCategoryExample();
//        ProductCategoryExample.Criteria criteria = example.createCriteria();
//        criteria.andStoreIdEqualTo(storeid).andCategoryParentIdEqualTo(0);
//        List<ProductCategory> parentlist = this.productCategoryService.queryAllObjByExample(example);
//
//        Map<String,Object> jsonObject = null;
//        List<Map<String,Object>> jsonList=new ArrayList<Map<String,Object>>();
//        if(!CollectionUtils.isEmpty(parentlist)){
//            for (ProductCategory category : parentlist){
//                jsonObject =new HashMap<String, Object>();
//                ProductCategoryExample example2 = new ProductCategoryExample();
//                ProductCategoryExample.Criteria criteria2 = example2.createCriteria();
//                criteria2.andCategoryParentIdEqualTo(category.getId());
//                List<ProductCategory> childrenlist = this.productCategoryService.queryAllObjByExample(example2);
//                jsonObject.put("categoryType",category.getCategoryName());
//                jsonObject.put("categoryTypeList",childrenlist);
//                jsonList.add(jsonObject);
//            }
//        }
//        result.setData(jsonList);
//        result.setMsg("查询成功");
//        result.setStatus("00");
//        return result;
//    }



}