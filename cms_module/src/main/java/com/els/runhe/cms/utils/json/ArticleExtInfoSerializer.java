package com.els.runhe.cms.utils.json;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.cms.entity.article.IArticleExtInfo;
import com.els.runhe.cms.entity.article.serializer.IArticleExtInfoSerializer;

public class ArticleExtInfoSerializer extends JsonSerializer<IArticleExtInfo>{

	private static Logger logger = LoggerFactory.getLogger(ArticleExtInfoSerializer.class);
	
	@Override
	public void serialize(IArticleExtInfo value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		
		IArticleExtInfoSerializer serializer = SpringContextHolder.getBean("articleExtInfoSerializer");
		if (serializer == null) {
			serializer = SpringContextHolder.getOneBean(IArticleExtInfoSerializer.class);
		}
		
		if(serializer == null){
			logger.warn("还没有配置文章拓展信息的序列化方式");
		}
		
		String json = "";
		if (value != null && serializer != null) {
			json = serializer.serializerToJson(value);
		}
		
		gen.writeString(json);
	}

}
