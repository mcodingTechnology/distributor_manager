package com.els.runhe.cms.dao.article;

import java.util.List;
import java.util.Map;

import com.els.base.core.dao.IMapper;
import com.els.runhe.cms.entity.article.Article;
import com.els.runhe.cms.entity.article.ArticleExample;

/**
 * ArticleMapper
 * 
 * @author acer
 * 
 */
public interface ArticleMapper extends IMapper<Article, ArticleExample>{

	int updateCount(Map<String, Object> map);

	List<Article> selectByPage(Map<String, Object> map);

	List<Article> selectFavoriteByPage(Map<String, Object> map);

	List<Article> selectCollectByPage(Map<String, Object> map);

	List<Article> selectLikeByPage(Map<String, Object> map);

}