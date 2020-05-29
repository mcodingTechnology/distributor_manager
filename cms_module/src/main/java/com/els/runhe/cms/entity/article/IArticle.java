package com.els.runhe.cms.entity.article;

import java.io.Serializable;

/**
 * 文章接口
 * 
 * @author acer
 * 
 */
public interface IArticle extends Serializable {

	public IArticleExtInfo getArticleExtInfo();

	public void setArticleExtInfo(IArticleExtInfo articleExtInfo);
}
