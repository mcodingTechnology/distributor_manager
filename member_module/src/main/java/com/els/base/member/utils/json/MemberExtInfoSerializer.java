package com.els.base.member.utils.json;

import java.io.IOException;

import com.els.base.member.entity.member.MemberExtInfo;
import com.els.base.utils.json.JsonUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MemberExtInfoSerializer extends JsonSerializer<MemberExtInfo> {

	@Override
	public void serialize(MemberExtInfo memberExtInfo, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		String json = "";
		if (memberExtInfo != null) {
			json = JsonUtils.writeValueAsString(memberExtInfo);
		}
		
		gen.writeString(json);
	}

}
