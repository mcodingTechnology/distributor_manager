package com.els.base.member.web.controller.department;

import java.util.List;

import javax.annotation.Resource;

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
import com.els.base.member.entity.department.Department;
import com.els.base.member.entity.department.DepartmentExample;
import com.els.base.member.service.department.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="会员_所属部门表")
@Controller("memberDepartment")
@RequestMapping("memberDepartment")
public class DepartmentController {
    @Resource
    protected DepartmentService memberDepartmentService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView(Integer parentId) {
    	ModelAndView view = new ModelAndView("member/memberDepartment/toAddView");
    	if (parentId !=null && parentId > 0) {
    		Department parent = this.memberDepartmentService.queryObjById(parentId);
    		view.addObject("parent", parent);
		}
        return view;
    }

    @ApiIgnore
    @RequestMapping("service/toDepartmentListView")
    public ModelAndView toDepartmentListView(int parentId) {
    	Department department = this.memberDepartmentService.queryObjById(parentId);
    	
    	ModelAndView view =new ModelAndView("member/memberDepartment/toDepartmentListView");
    	view.addObject("parent", department);
        return view;
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        Department memberDepartment = this.memberDepartmentService.queryObjById(id);
        view.addObject("memberDepartment", memberDepartment);
        
        Department parent = this.memberDepartmentService.queryObjById(memberDepartment.getParentId());
        view.addObject("parent", parent);
        
        view.setViewName("member/memberDepartment/toAddView");
        return view;
    }
    
    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("member/memberDepartment/toMainView");
    }

    @ApiOperation(httpMethod="POST", value="创建会员_所属部门表")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Department memberDepartment) {
        this.memberDepartmentService.addObj(memberDepartment);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑会员_所属部门表")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Department memberDepartment) {
        if (memberDepartment.getId() == null || memberDepartment.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.memberDepartmentService.modifyObj(memberDepartment);
        return ResponseResult.success();
    }

    /*@ApiOperation(httpMethod="POST", value="删除会员_所属部门表")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        ResponseResult<String> result = new ResponseResult<>();
        this.memberDepartmentService.deleteObjById(id);
        result.setData(null);
        result.setMsg("ok");
        result.setStatus("00");
        return result;
    }*/

    @ApiOperation(httpMethod="GET", value="查询会员_所属部门表")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<Department>> findByPage(
    		@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="0") Integer pageNo, 
    		@ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") Integer pageSize, 
    		@ApiParam(value="查询条件") String sSearch,
    		@ApiParam(value="上级id", defaultValue="0") @RequestParam(defaultValue="0") int parentId) {
        PageView<Department> pageView = new PageView<>(pageNo, pageSize);
        
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria cri = example.createCriteria();
        cri.andParentIdEqualTo(parentId);
        
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
        	cri.andCompanyNameLike(sSearch + "%");
        }
        pageView = this.memberDepartmentService.queryObjByPage(example);
        return ResponseResult.success(pageView);
    }
    
    @ApiOperation(httpMethod="GET", value="查询所有公司")
    @RequestMapping("service/findAllCompany")
    @ResponseBody
    public ResponseResult<List<Department>> findAllCompany() {
        
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria cri = example.createCriteria();
        cri.andDepartmentTypeEqualTo(Department.TYPE_COMPANY);
        
        return ResponseResult.success(this.memberDepartmentService.queryAllObjByExample(example));
    }
}
