package com.els.runhe.cms.web.controller.collect;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.core.entity.ResponseResult;
import com.els.base.member.entity.member.Member;
import com.els.runhe.cms.entity.collect.Collect;
import com.els.runhe.cms.entity.collect.CollectExample;
import com.els.runhe.cms.service.collect.CollectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * CollectController
 * 
 * @author acer
 * 
 */
@Api("收藏")
@Controller
@RequestMapping("collect")
public class CollectController {

	@Autowired
	private CollectService collectService;

	/**
	 * 收藏或者取消收藏
	 * 
	 * @param articleId
	 * @param status
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "点赞或者取消点赞", httpMethod = "GET", notes = "status(0:收藏,1:取消收藏)")
	@RequestMapping("front/collectOrUncollect")
	@ResponseBody
	public ResponseResult<String> collectOrUncollect(int articleId, int status,HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		return collectService.collectOrUncollect(member.getId(), articleId, status, 0);
	}

	/**
	 * 根据条件查询收藏
	 * 
	 * @param articleId
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "根据条件查询收藏", httpMethod = "GET")
	@RequestMapping("front/findCollect")
	@ResponseBody
	public ResponseResult<Collect> find(int articleId, HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		Collect collect = findCollect(articleId, 0, member.getId());
		return ResponseResult.success(collect);
	}

	/**
	 * 根据条件查询收藏
	 * 
	 * @param articleId
	 * @param storeId
	 * @param memberId
	 * @return
	 */
	public Collect findCollect(int articleId, int storeId, String memberId) {
		CollectExample example = new CollectExample();
		example.createCriteria().andArticleIdEqualTo(articleId).andMemberIdEqualTo(memberId);
//		example.createCriteria().andArticleIdEqualTo(articleId)
//		.andStoreIdEqualTo(storeId).andMemberIdEqualTo(memberId);
		List<Collect> list = collectService.queryAllObjByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}