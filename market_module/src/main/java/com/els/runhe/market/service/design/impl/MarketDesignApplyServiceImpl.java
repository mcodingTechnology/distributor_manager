package com.els.runhe.market.service.design.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.codegenerator.service.GenerateCodeService;
import com.els.base.core.entity.PageView;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.market.dao.design.MarketDesignApplyMapper;
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.entity.design.MarketDesignApplyExample;
import com.els.runhe.market.entity.design.MarketDesigned;
import com.els.runhe.market.entity.design.MarketDesignedExample;
import com.els.runhe.market.service.design.MarketDesignApplyService;
import com.els.runhe.market.service.design.MarketDesignedService;

@Service("defaultMarketDesignApplyService")
public class MarketDesignApplyServiceImpl implements MarketDesignApplyService {
    @Resource
    protected MarketDesignApplyMapper marketDesignApplyMapper;
    
    @Resource
    protected MarketDesignedService marketDesignedServiceImpl;

    private static final String DESIGN_CODE_GENERATE = "MARKET_DESIGN_CODE";
    protected static GenerateCodeService generateCodeService  = SpringContextHolder.getOneBean(GenerateCodeService.class);
    
    @CacheEvict(value={"marketDesignApply"}, allEntries=true)
    @Override
    public void addObj(MarketDesignApply t) {
    	//设计申请编号自动生成 例如：MD2017111300000001
    	String code =generateCodeService.getNextCode(DESIGN_CODE_GENERATE);
    	t.setDesignApplyId(code);
        this.marketDesignApplyMapper.insertSelective(t);
        
        //添加设计资料
        if(CollectionUtils.isNotEmpty(t.getDesignedList())){
        	for(MarketDesigned marketDesigned:t.getDesignedList()){
        		marketDesigned.setDesignApplyId(code);
        		this.marketDesignedServiceImpl.addObj(marketDesigned);
        	}
        }
        
        //启动审批
        //SpringContextHolder.getApplicationContext().publishEvent(new MarketDesignApplyEvent(t));
    }

    @CacheEvict(value={"marketDesignApply"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.marketDesignApplyMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"marketDesignApply"}, allEntries=true)
    @Override
    public void modifyObj(MarketDesignApply t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.marketDesignApplyMapper.updateByPrimaryKeySelective(t);
        //编辑设计资料
        if(CollectionUtils.isNotEmpty(t.getDesignedList())){
        	for(MarketDesigned marketDesigned:t.getDesignedList()){
        		if(marketDesigned.getId()!=null && StringUtils.isNotEmpty(marketDesigned.getDesignApplyId())){
        			this.marketDesignedServiceImpl.modifyObj(marketDesigned);
        		}else{
        			marketDesigned.setDesignApplyId(t.getDesignApplyId());
        			this.marketDesignedServiceImpl.addObj(marketDesigned);
        		}
        	}
        }
        
    }

    @Cacheable(value="marketDesignApply", keyGenerator="redisKeyGenerator")
    @Override
    public MarketDesignApply queryObjById(Integer id) {
        return this.marketDesignApplyMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="marketDesignApply", keyGenerator="redisKeyGenerator")
    @Override
    public List<MarketDesignApply> queryAllObjByExample(MarketDesignApplyExample example) {
        return this.marketDesignApplyMapper.selectByExample(example);
    }

    @Cacheable(value="marketDesignApply", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<MarketDesignApply> queryObjByPage(MarketDesignApplyExample example) {
        PageView<MarketDesignApply> pageView = example.getPageView();
        
        List<MarketDesignApply> marketDesignList =this.marketDesignApplyMapper.selectByExampleByPage(example);
        //查询设计资料
        for(int i=0;CollectionUtils.isNotEmpty(marketDesignList)&&i<marketDesignList.size();i++){
        	this.setItems(marketDesignList.get(i));
        }
        pageView.setQueryResult(marketDesignList);
        return pageView;
    }

    @CacheEvict(value={"marketDesignApply"}, allEntries=true)
	@Override
	public void modifyObjByExample(MarketDesignApply record, MarketDesignApplyExample example) {
		this.marketDesignApplyMapper.updateByExampleSelective(record, example);
	}

	@Cacheable(value="marketDesignApply", keyGenerator="redisKeyGenerator")
	@Override
	public MarketDesignApply queryByDesignApplyId(String designApplyId) {
		MarketDesignApply marketDesignApply = this.marketDesignApplyMapper.selectByDesignApplyId(designApplyId);
		return marketDesignApply;
	}
	
	/**
	 * 将设计资料关联到市场平面设计申请信息
	 * @param record
	 */
	private void setItems(MarketDesignApply record){
		if(StringUtils.isBlank(record.getDesignApplyId())){
			return;
		}
		//根据设计申请编号查询设计资料
		MarketDesignedExample example = new MarketDesignedExample();
		example.createCriteria().andDesignApplyIdEqualTo(record.getDesignApplyId());
		record.setDesignedList(this.marketDesignedServiceImpl.queryAllObjByExample(example));
	}
}