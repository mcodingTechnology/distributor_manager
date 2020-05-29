package com.els.base.member.service.department.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.member.dao.department.MemberDepartmentMapper;
import com.els.base.member.entity.department.Department;
import com.els.base.member.entity.department.DepartmentExample;
import com.els.base.member.service.department.DepartmentService;

@Service("memberDepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
    protected MemberDepartmentMapper departmentMapper;

    @CacheEvict(value={"department"}, allEntries=true)
    @Override
    public void addObj(Department t) {
        this.departmentMapper.insertSelective(t);
    }

    @CacheEvict(value={"department"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.departmentMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"department"}, allEntries=true)
    @Override
    public void modifyObj(Department t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.departmentMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="department", key="'DepartmentService_' + #root.methodName + '_' +#id")
    @Override
    public Department queryObjById(Integer id) {
        return this.departmentMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="department", key="'DepartmentService_' + #root.methodName + '_'+ #example.toJson()")
    @Override
    public List<Department> queryAllObjByExample(DepartmentExample example) {
        return this.departmentMapper.selectByExample(example);
    }

    @Cacheable(value="department", key="'DepartmentService_' + #root.methodName + '_'+ #example.toJson()")
    @Override
    public PageView<Department> queryObjByPage(DepartmentExample example) {
        PageView<Department> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.departmentMapper.selectByExampleByPage(example));
        return pageView;
    }
}