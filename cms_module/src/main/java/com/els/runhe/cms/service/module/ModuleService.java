package com.els.runhe.cms.service.module;

import java.util.List;
import java.util.Map;

import com.els.base.core.service.BaseService;
import com.els.runhe.cms.entity.module.Module;
import com.els.runhe.cms.entity.module.ModuleExample;
import com.els.base.core.entity.PageView;

/**
 * ModuleService
 * 
 * @author acer
 * 
 */
public interface ModuleService extends BaseService<Module, ModuleExample, Integer> {

	List<Module> selectModules(Map<String, Object> map);
	
    public PageView<Module> selectByPage(Integer storeId);
}
