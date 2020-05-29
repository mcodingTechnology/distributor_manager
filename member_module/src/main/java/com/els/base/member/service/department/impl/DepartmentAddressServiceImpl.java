package com.els.base.member.service.department.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.member.dao.department.DepartmentAddressMapper;
import com.els.base.member.entity.department.DepartmentAddress;
import com.els.base.member.entity.department.DepartmentAddressExample;
import com.els.base.member.service.department.DepartmentAddressService;

@Service("departmentAddressService")
public class DepartmentAddressServiceImpl implements DepartmentAddressService {
    @Resource
    protected DepartmentAddressMapper departmentAddressMapper;

    @CacheEvict(value={"departmentAddress"}, allEntries=true)
    @Override
    public void addObj(DepartmentAddress t) {
        this.departmentAddressMapper.insertSelective(t);
    }

    @CacheEvict(value={"departmentAddress"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.departmentAddressMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"departmentAddress"}, allEntries=true)
    @Override
    public void modifyObj(DepartmentAddress t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.departmentAddressMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="departmentAddress", key="'DepartmentAddressService_' + #root.methodName + '_' +#id")
    @Override
    public DepartmentAddress queryObjById(Integer id) {
        return this.departmentAddressMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="departmentAddress", key="'DepartmentAddressService_' + #root.methodName + '_'+ #example.toJson()")
    @Override
    public List<DepartmentAddress> queryAllObjByExample(DepartmentAddressExample example) {
        return this.departmentAddressMapper.selectByExample(example);
    }

    @Cacheable(value="departmentAddress", key="'DepartmentAddressService_' + #root.methodName + '_'+ #example.toJson()")
    @Override
    public PageView<DepartmentAddress> queryObjByPage(DepartmentAddressExample example) {
        PageView<DepartmentAddress> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.departmentAddressMapper.selectByExampleByPage(example));
        return pageView;
    }
}