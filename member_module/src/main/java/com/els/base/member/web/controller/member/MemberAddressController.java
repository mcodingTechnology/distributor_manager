package com.els.base.member.web.controller.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.member.entity.member.Member;
import com.els.base.member.entity.member.MemberAddress;
import com.els.base.member.entity.member.MemberAddressExample;
import com.els.base.member.service.member.MemberAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="地址")
@Controller
@RequestMapping("memberAddress")
public class MemberAddressController {
    @Resource
    protected MemberAddressService memberAddressService;

    @ApiOperation(httpMethod="POST", value="创建地址")
    @RequestMapping("front/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody MemberAddress memberAddress, HttpSession session) {
    	Member member = (Member) session.getAttribute("member");
    	memberAddress.setMemberId(Integer.valueOf(member.getId()));
    	
    	this.memberAddressService.addObj(memberAddress);
        
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑地址")
    @RequestMapping("front/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody MemberAddress memberAddress) {
        if (memberAddress.getId() == null || memberAddress.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        
        memberAddress.setMemberId(null);
        this.memberAddressService.modifyObj(memberAddress);
        
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="删除地址")
    @RequestMapping(value={"service/deleteById","front/deleteById"})
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.memberAddressService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="查询地址")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<MemberAddress>> findByPage(
    		@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="1") int pageNo, 
    		@ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize, 
    		@ApiParam(value="查询条件") String sSearch) {
        PageView<MemberAddress> pageView = new PageView<>(pageNo, pageSize);
        MemberAddressExample example = new MemberAddressExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        return ResponseResult.success(this.memberAddressService.queryObjByPage(example));
    }
    
    @ApiOperation(httpMethod="GET", value="查询当前用户的地址")
    @RequestMapping("front/findByCurrentMember")
    @ResponseBody
    public PageView<MemberAddress> findByCurrentMember(
    		@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="1") int pageNo, 
    		@ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize,
    		HttpSession session) {
    	Member member = (Member) session.getAttribute("member");
    	
    	PageView<MemberAddress> pageView = new PageView<>(pageNo, pageSize);
    	MemberAddressExample example = new MemberAddressExample();
    	example.setPageView(pageView);
    	
    	example.createCriteria().andMemberIdEqualTo(Integer.valueOf(member.getId()));
    	example.setOrderByClause("is_default DESC, id DESC");
    	
    	return this.memberAddressService.queryObjByPage(example);
    }
    
    @ApiOperation(httpMethod="GET", value="查询地址详情")
    @RequestMapping("front/findById")
    @ResponseBody
    public ResponseResult<MemberAddress> findById(int id) {
		return ResponseResult.success(this.memberAddressService.queryObjById(id));
	}
}