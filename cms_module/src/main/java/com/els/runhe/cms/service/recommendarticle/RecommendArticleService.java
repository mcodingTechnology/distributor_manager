package com.els.runhe.cms.service.recommendarticle;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.cms.entity.recommendarticle.RecommendArticle;
import com.els.runhe.cms.entity.recommendarticle.RecommendArticleExample;

/**
 * RecommendArticleService
 * 
 * @author acer
 * 
 */
public interface RecommendArticleService extends BaseService<RecommendArticle, RecommendArticleExample, Integer> {
	
	public void addOrDeleteByArticleId(int articleId, List<RecommendArticle> recommendArticleList);
	
	public void deleteByArticleId(int articleId);

}
