package com.els.runhe.cms.entity.article.serializer;

import com.els.runhe.cms.entity.article.IArticleExtInfo;

public interface IArticleExtInfoSerializer {
	
	public String serializerToJson(IArticleExtInfo articleExtInfo);
	
	public IArticleExtInfo deserializerFormJson(String json);
}
