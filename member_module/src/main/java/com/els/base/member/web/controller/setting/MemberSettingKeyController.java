package com.els.base.member.web.controller.setting;

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
import com.els.base.member.entity.setting.MemberSettingKey;
import com.els.base.member.entity.setting.MemberSettingKeyExample;
import com.els.base.member.service.setting.MemberSettingKeyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="会员配置项目")
@Controller
@RequestMapping("memberSettingKey")
public class MemberSettingKeyController {
    @Resource
    protected MemberSettingKeyService memberSettingKeyService;

    @ApiIgnore
    @RequestMapping("service/toAddView")
    public ModelAndView toAddView() {
        return new ModelAndView("member/memberSettingKey/toAddView");
    }

    @ApiIgnore
    @RequestMapping("service/toMainView")
    public ModelAndView toMainView() {
        return new ModelAndView("member/memberSettingKey/toMainView");
    }

    @ApiIgnore
    @RequestMapping("service/toUpdateViewById")
    public ModelAndView toUpdateViewById(int id) {
        ModelAndView view = new ModelAndView();
        MemberSettingKey memberSettingKey = this.memberSettingKeyService.queryObjById(id);
        view.addObject("memberSettingKey", memberSettingKey);
        view.setViewName("member/memberSettingKey/toAddView");
        return view;
    }

    @ApiOperation(httpMethod="POST", value="创建会员配置")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody MemberSettingKey memberSettingKey) {
        this.memberSettingKeyService.addObj(memberSettingKey);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑会员配置")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody MemberSettingKey memberSettingKey) {
        if (memberSettingKey.getId() == null || memberSettingKey.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.memberSettingKeyService.modifyObj(memberSettingKey);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除会员配置")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(int id) {
        this.memberSettingKeyService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="GET", value="查询会员配置")
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<MemberSettingKey>> findByPage(
    		@ApiParam(name="分页索引",defaultValue="0") @RequestParam(defaultValue="1") int pageNo, @ApiParam(name="每页的数量",defaultValue="10") @RequestParam(defaultValue="10") int pageSize, @ApiParam(value="查询条件") String sSearch) {
        PageView<MemberSettingKey> pageView = new PageView<>(pageNo, pageSize);
        MemberSettingKeyExample example = new MemberSettingKeyExample();
        example.setPageView(pageView);
        if (StringUtils.isNotBlank(sSearch)) {
            // TODO Auto-generated method stub
        }
        return ResponseResult.success(this.memberSettingKeyService.queryObjByPage(example));
    }
}