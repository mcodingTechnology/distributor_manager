package com.els.runhe.cms.web.controller.recommendarticle;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.runhe.cms.entity.recommendarticle.RecommendArticle;
import com.els.runhe.cms.entity.recommendarticle.RecommendArticleExample;
import com.els.runhe.cms.service.recommendarticle.RecommendArticleService;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.PageView;

/**
 * RecommendArticleController
 * 
 * @author acer
 * 
 */
@Api("推荐文章")
@Controller
@RequestMapping("recommendArticle")
public class RecommendArticleController {

	@Autowired
	private RecommendArticleService recommendArticleService;

	@RequestMapping("service/addRecommendArticle")
	@ResponseBody
	public ResponseResult<String> addArticle(
			@RequestBody RecommendArticle recommendArticle) {
		recommendArticleService.addObj(recommendArticle);
		return ResponseResult.success();
	}

	@RequestMapping("service/findByArticleId")
	@ResponseBody
	public ResponseResult<List<RecommendArticle>> findByArticleId(int articleId) {

		RecommendArticleExample example = new RecommendArticleExample();
		example.createCriteria().andRefIdEqualTo(articleId);

		List<RecommendArticle> list = this.recommendArticleService
				.queryAllObjByExample(example);

		return ResponseResult.success(list);
	}

	/**
	 * 根据文章查推荐文章
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param articleId
	 * @return
	 */
	@ApiOperation(value = "根据文章查推荐文章", httpMethod = "GET")
	@RequestMapping("front/queryRecommendArticlePage")
	@ResponseBody
	public PageView<RecommendArticle> queryRecommendArticlePage(
			int pageNo, int pageSize, Integer articleId) {
		RecommendArticleExample example = new RecommendArticleExample();
		PageView<RecommendArticle> pageView = new PageView<RecommendArticle>(
				pageNo, pageSize);
		example.setPageView(pageView);
		example.createCriteria().andRefIdEqualTo(articleId);
		example.setOrderByClause(" create_time desc ");
		List<RecommendArticle> articleList = recommendArticleService
				.queryAllObjByExample(example);
		pageView.setQueryResult(articleList);
		return pageView;
	}

}