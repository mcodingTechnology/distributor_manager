package com.els.runhe.product.web.controller.productScene;

import com.els.runhe.product.entity.productScene.ProductScene;
import com.els.runhe.product.entity.productScene.ProductSceneExample;
import com.els.runhe.product.service.productScene.ProductSceneService;
import com.els.base.core.exception.CommonException;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.PageView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="产品场景")
@Controller
@RequestMapping("productScene")
public class ProductSceneController {
    @Resource
    protected ProductSceneService productSceneService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("sns/productScene/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("sns/productScene/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        ProductScene productScene = this.productSceneService.queryObjById(id);
        view.addObject("productScene", productScene);
        view.setViewName("sns/productScene/toAddView");
        return view;
    }

    @ApiOperation(httpMethod = "POST", value = "创建产品场景")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ProductScene productScene) {
        this.productSceneService.addObj(productScene);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod = "POST", value = "编辑产品场景")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ProductScene productScene) {
        if (productScene.getId() == null || productScene.getId() <= 0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.productSceneService.modifyObj(productScene);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod = "POST", value = "删除产品场景")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.productSceneService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod = "GET", value = "查询产品场景")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<ProductScene>> findByPage(
    		@ApiParam(name = "分页索引") @RequestParam(defaultValue = "1") int pageNo, 
    		@ApiParam(name = "每页的数量") @RequestParam(defaultValue = "10") int pageSize, 
    		@ApiParam(value = "查询条件") String sSearch) {
        PageView<ProductScene> pageView = new PageView<>(pageNo, pageSize);
        ProductSceneExample example = new ProductSceneExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        return ResponseResult.success(this.productSceneService.queryObjByPage(example));
    }

    @ApiIgnore
    @ApiOperation(httpMethod = "GET", value = "查询所有产品场景")
    @RequestMapping("service/findAll")
    @ResponseBody
    public ResponseResult<List<ProductScene>> findAll() {
        return ResponseResult.success(this.productSceneService.queryAllObjByExample(new ProductSceneExample()));
        
    }
}