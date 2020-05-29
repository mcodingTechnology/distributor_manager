package com.els.base.member.web.controller.department;

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
import com.els.base.member.entity.department.DepartmentAddress;
import com.els.base.member.entity.department.DepartmentAddressExample;
import com.els.base.member.service.department.DepartmentAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="公司地址")
@Controller
@RequestMapping("departmentAddress")
public class DepartmentAddressController {
    @Resource
    protected DepartmentAddressService departmentAddressService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("member/departmentAddress/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("member/departmentAddress/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        DepartmentAddress departmentAddress = this.departmentAddressService.queryObjById(id);
        view.addObject("departmentAddress", departmentAddress);
        view.setViewName("member/departmentAddress/toAddView");
        return view;
    }

    @ApiOperation(httpMethod="POST", value="创建公司地址")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody DepartmentAddress departmentAddress) {
        this.departmentAddressService.addObj(departmentAddress);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑公司地址")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody DepartmentAddress departmentAddress) {
        if (departmentAddress.getId() == null || departmentAddress.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.departmentAddressService.modifyObj(departmentAddress);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除公司地址")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.departmentAddressService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="查询公司地址")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<DepartmentAddress>> findByPage(
    		@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="1") int pageNo, 
    		@ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize, 
    		@ApiParam(value="查询条件") String sSearch) {
        PageView<DepartmentAddress> pageView = new PageView<>(pageNo, pageSize);
        DepartmentAddressExample example = new DepartmentAddressExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        pageView = this.departmentAddressService.queryObjByPage(example);
        return ResponseResult.success(pageView);
    }
}