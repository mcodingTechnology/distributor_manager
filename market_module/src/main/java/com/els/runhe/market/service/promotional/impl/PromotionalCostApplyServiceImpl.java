package com.els.runhe.market.service.promotional.impl;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.codegenerator.service.GenerateCodeService;
import com.els.base.core.entity.PageView;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.market.dao.promotional.PromotionalCostApplyMapper;
import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.entity.promotional.PromotionalCostApplyExample;
import com.els.runhe.market.entity.promotional.PromotionalCostProject;
import com.els.runhe.market.entity.promotional.PromotionalCostProjectExample;
import com.els.runhe.market.service.promotional.PromotionalCostApplyService;
import com.els.runhe.market.service.promotional.PromotionalCostProjectService;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultPromotionalCostApplyService")
public class PromotionalCostApplyServiceImpl implements PromotionalCostApplyService {
    @Resource
    protected PromotionalCostApplyMapper promotionalCostApplyMapper;
    
    @Resource
    protected PromotionalCostProjectService promotionalCostProjectService;
    
    private static final String COST_CODE_GENERATE = "PROMOTIONAL_COST_CODE";
    protected static GenerateCodeService generateCodeService  = SpringContextHolder.getOneBean(GenerateCodeService.class);
    

    @CacheEvict(value={"promotionalCostApply"}, allEntries=true)
    @Override
    public void addObj(PromotionalCostApply t) {
    	//费用申请编号自动生成
    	String code =generateCodeService.getNextCode(COST_CODE_GENERATE);
    	t.setPromotionalCostNo(code);
    	t.setUserId(SpringSecurityUtils.getLoginUserId());
    	t.setUserName(SpringSecurityUtils.getLoginUserName());
        this.promotionalCostApplyMapper.insertSelective(t);
        
        //添加活动项目
        if(CollectionUtils.isNotEmpty(t.getCostProjectList())){
        	for(PromotionalCostProject project:t.getCostProjectList()){
        		project.setPromotionalCostNo(code);
        		this.promotionalCostProjectService.addObj(project);
        	}
        }
    }

    @CacheEvict(value={"promotionalCostApply"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.promotionalCostApplyMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"promotionalCostApply"}, allEntries=true)
    @Override
    public void modifyObj(PromotionalCostApply t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        if(CollectionUtils.isNotEmpty(t.getCostProjectList())){
        	//编辑费用申请
        	this.promotionalCostApplyMapper.updateByPrimaryKeySelective(t);
        	 
        	//编辑费用申请项目 
        	for(PromotionalCostProject project:t.getCostProjectList()){
        		if(project.getId()!=null && StringUtils.isNotEmpty(project.getPromotionalCostNo())){
        			this.promotionalCostProjectService.modifyObj(project);
        		}else{
        			project.setPromotionalCostNo(t.getPromotionalCostNo());
        			this.promotionalCostProjectService.addObj(project);
        		}
        	}
        }else if (t.getStatus() != null ) {
        	this.promotionalCostApplyMapper.updateByPrimaryKeySelective(t);
        }
    }

    @Cacheable(value="promotionalCostApply", keyGenerator="redisKeyGenerator")
    @Override
    public PromotionalCostApply queryObjById(Integer id) {
        return this.promotionalCostApplyMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="promotionalCostApply", keyGenerator="redisKeyGenerator")
    @Override
    public List<PromotionalCostApply> queryAllObjByExample(PromotionalCostApplyExample example) {
        return this.promotionalCostApplyMapper.selectByExample(example);
    }

    @Cacheable(value="promotionalCostApply", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<PromotionalCostApply> queryObjByPage(PromotionalCostApplyExample example) {
        PageView<PromotionalCostApply> pageView = example.getPageView();
        List<PromotionalCostApply> promotionalCostList = this.promotionalCostApplyMapper.selectByExampleByPage(example);
        //查询申请项目行
        for(int i=0;CollectionUtils.isNotEmpty(promotionalCostList)&&i<promotionalCostList.size();i++){
        	this.setItems(promotionalCostList.get(i));
        }
        pageView.setQueryResult(promotionalCostList);
        return pageView;
    }
    
	@Override
	public void modifyObjByExample(PromotionalCostApply record, PromotionalCostApplyExample example) {
		this.promotionalCostApplyMapper.updateByExampleSelective(record, example);
	}

	@Override
	public PromotionalCostApply queryByPromotionalCostNo(String promotionalCostNo) {
		PromotionalCostApply promotionalCostApply = this.promotionalCostApplyMapper.selectByPromotionalCostNo(promotionalCostNo);
		return promotionalCostApply;
	}
	
	/**
     * 将项目行明细关联到费用申请
     * @param record
     */
    private void setItems(PromotionalCostApply record){
    	if(StringUtils.isBlank(record.getPromotionalCostNo())){
    		return;
    	}
    	//根据费用申请编号查询项目明细
    	PromotionalCostProjectExample example = new PromotionalCostProjectExample();
    	example.createCriteria().andPromotionalCostNoEqualTo(record.getPromotionalCostNo());
    	record.setCostProjectList(this.promotionalCostProjectService.queryAllObjByExample(example));
    }
}