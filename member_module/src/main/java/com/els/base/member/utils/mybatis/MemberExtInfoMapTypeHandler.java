/**
 * 
 */
package com.els.base.member.utils.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.els.base.member.entity.member.IMemberExtInfo;
import com.els.base.member.service.member.IMemberExtInfoLoader;
import com.els.base.utils.SpringContextHolder;

/**
 * @author hzy
 *
 */
public class MemberExtInfoMapTypeHandler implements TypeHandler<Map<String, IMemberExtInfo>>{
	
	public MemberExtInfoMapTypeHandler() {
		super();
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Map<String, IMemberExtInfo> parameter, JdbcType jdbcType)
			throws SQLException {
	}

	@Override
	public Map<String, IMemberExtInfo> getResult(ResultSet rs, String columnName) throws SQLException {
		String memberId = rs.getString(columnName);
		return loadMemberExtInfo(memberId);
	}

	@Override
	public Map<String, IMemberExtInfo> getResult(ResultSet rs, int columnIndex) throws SQLException {
		String memberId = rs.getString(columnIndex);
		return loadMemberExtInfo(memberId);
	}

	@Override
	public Map<String, IMemberExtInfo> getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String memberId = cs.getString(columnIndex);
		return loadMemberExtInfo(memberId);
	}
	
	/**
	 * 加载会员拓展消息
	 * @param memberId
	 * @return
	 */
	private Map<String, IMemberExtInfo> loadMemberExtInfo(String memberId){
		Map<String, IMemberExtInfo> map = new HashMap<>();
		
		Map<String, IMemberExtInfoLoader> loaderList = SpringContextHolder.getBeans(IMemberExtInfoLoader.class);
		Iterator<Entry<String, IMemberExtInfoLoader>> iterator = loaderList.entrySet().iterator();
		while (iterator.hasNext()) {
			IMemberExtInfoLoader loader = iterator.next().getValue();
			String type = loader.getMemberExtInfoType();
			IMemberExtInfo memberExtInfo = loader.getMemberExtInfo(memberId);
			
			map.put(type, memberExtInfo);
		}
		
		return map;
	}
}
