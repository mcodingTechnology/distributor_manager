package com.els.runhe.cms.service.module.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.core.utils.Constant;
import com.els.runhe.cms.dao.module.ModuleMapper;
import com.els.runhe.cms.entity.module.Module;
import com.els.runhe.cms.entity.module.ModuleExample;
import com.els.runhe.cms.service.module.ModuleService;

/**
 * ModuleServiceImpl
 * 
 * @author acer
 * 
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	protected ModuleMapper moduleMapper;

	@Override
	public void addObj(Module module) {
		moduleMapper.insertSelective(module);
	}

	@Override
	public void deleteObjById(Integer moduleId) {
		moduleMapper.deleteByPrimaryKey(moduleId);
	}

	@Override
	public void modifyObj(Module module) {
		moduleMapper.updateByPrimaryKeySelective(module);
	}

	@Override
	public List<Module> queryAllObjByExample(ModuleExample moduleExample) {
		return moduleMapper.selectByExample(moduleExample);
	}

	@Override
	public Module queryObjById(Integer moduleId) {
		return moduleMapper.selectByPrimaryKey(moduleId);
	}

	@Override
	public PageView<Module> queryObjByPage(ModuleExample example) {
		PageView<Module> pageView = example.getPageView();
		if (pageView == null) {
			pageView = new PageView<Module>();
			pageView.setPageNo(1);
			pageView.setPageSize(10);
			example.setPageView(pageView);
		}
		List<Module> list = moduleMapper.selectByExampleByPage(example);
		pageView.setQueryResult(list);
		return pageView;
	}

	@Override
	public List<Module> selectModules(Map<String, Object> map) {
		return moduleMapper.selectModules(map);
	}
	
	@Override
    public PageView<Module> selectByPage(Integer storeId){
    	PageView<Module> pageView = new PageView<Module>();
    	ModuleExample example = new ModuleExample();
    	example.createCriteria().andStatusEqualTo(Constant.NO_INT);
//    	example.createCriteria().andStoreIdEqualTo(storeId).andStatusEqualTo(Constant.NO_INT);
    	pageView.setQueryResult(this.moduleMapper.selectByExample(example));
    	return pageView;
    }

}
