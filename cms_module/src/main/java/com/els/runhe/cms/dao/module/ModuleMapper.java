package com.els.runhe.cms.dao.module;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.els.runhe.cms.entity.module.Module;
import com.els.runhe.cms.entity.module.ModuleExample;

/**
 * ModuleMapper
 * 
 * @author acer
 * 
 */
public interface ModuleMapper {

	int countByExample(ModuleExample example);

	int deleteByExample(ModuleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Module record);

	int insertSelective(Module record);

	List<Module> selectByExample(ModuleExample example);

	Module selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Module record,
			@Param("example") ModuleExample example);

	int updateByExample(@Param("record") Module record,
			@Param("example") ModuleExample example);

	int updateByPrimaryKeySelective(Module record);

	int updateByPrimaryKey(Module record);

	List<Module> selectByExampleByPage(ModuleExample example);

	List<Module> selectModules(Map<String, Object> map);
}