package com.els.runhe.market.web.controller.promotional;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.market.entity.promotional.PromotionalCostProject;
import com.els.runhe.market.entity.promotional.PromotionalCostProjectExample;
import com.els.runhe.market.service.promotional.PromotionalCostProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value="促销活动费用申请项目表")
@Controller
@RequestMapping("promotionalCostProject")
public class PromotionalCostProjectController {
    @Resource
    protected PromotionalCostProjectService promotionalCostProjectService;

    /*@ApiOperation(httpMethod="POST", value="创建促销活动费用申请项目表")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody PromotionalCostProject promotionalCostProject) {
        this.promotionalCostProjectService.addObj(promotionalCostProject);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑促销活动费用申请项目表")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody PromotionalCostProject promotionalCostProject) {
        if (promotionalCostProject.getId() == null || promotionalCostProject.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.promotionalCostProjectService.modifyObj(promotionalCostProject);
        return ResponseResult.success();
    }*/

    /*@ApiOperation(httpMethod="POST", value="删除促销活动费用申请项目表")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.promotionalCostProjectService.deleteObjById(id);
        return ResponseResult.success();
    }*/

    @ApiOperation(httpMethod="POST", value="查询促销活动费用申请项目表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 PromotionalCostProject", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<PromotionalCostProject>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        PromotionalCostProjectExample example = new PromotionalCostProjectExample();
        example.setPageView(new PageView<PromotionalCostProject>(pageNo, pageSize));
        
        if (wapper != null) {
            PromotionalCostProjectExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<PromotionalCostProject> pageData = this.promotionalCostProjectService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}