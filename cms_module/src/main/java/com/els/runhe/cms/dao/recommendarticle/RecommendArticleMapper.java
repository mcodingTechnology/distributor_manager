package com.els.runhe.cms.dao.recommendarticle;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.els.runhe.cms.entity.recommendarticle.RecommendArticle;
import com.els.runhe.cms.entity.recommendarticle.RecommendArticleExample;

/**
 * RecommendArticleMapper
 * 
 * @author acer
 * 
 */
public interface RecommendArticleMapper {

	int countByExample(RecommendArticleExample example);

	int deleteByExample(RecommendArticleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(RecommendArticle record);

	int insertSelective(RecommendArticle record);

	List<RecommendArticle> selectByExample(RecommendArticleExample example);

	RecommendArticle selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") RecommendArticle record,
			@Param("example") RecommendArticleExample example);

	int updateByExample(@Param("record") RecommendArticle record,
			@Param("example") RecommendArticleExample example);

	int updateByPrimaryKeySelective(RecommendArticle record);

	int updateByPrimaryKey(RecommendArticle record);

	List<RecommendArticle> selectByExampleByPage(RecommendArticleExample example);
}