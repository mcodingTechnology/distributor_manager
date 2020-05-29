package com.els.runhe.statisticAnalysis.service.Impl;


import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.els.base.core.entity.PageView;
import com.els.runhe.statisticAnalysis.dao.AnalysisOrderMapper;
import com.els.runhe.statisticAnalysis.dao.AnalysisOrderProductMapper;
import com.els.runhe.statisticAnalysis.dao.OrderStatisticAnalysisMapper;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrder;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderExample;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProduct;
import com.els.runhe.statisticAnalysis.service.AnalysisOrderService;
import com.els.runhe.statisticAnalysis.utils.StatisticAnalysisDateUtil;

@Service("defaultAnalysisOrderService")
public class AnalysisOrderServiceImpl implements AnalysisOrderService {
    @Resource
    protected AnalysisOrderMapper analysisOrderMapper;
    @Resource
	private AnalysisOrderProductMapper analysisOrderProductMapper;
	@Resource
	private OrderStatisticAnalysisMapper orderStatisticAnalysisMapper;

    @CacheEvict(value={"analysisOrder"}, allEntries=true)
    @Override
    public void addObj(AnalysisOrder t) {
        this.analysisOrderMapper.insertSelective(t);
    }

    @CacheEvict(value={"analysisOrder"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.analysisOrderMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"analysisOrder"}, allEntries=true)
    @Override
    public void modifyObj(AnalysisOrder t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.analysisOrderMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="analysisOrder", keyGenerator="redisKeyGenerator")
    @Override
    public AnalysisOrder queryObjById(Integer id) {
        return this.analysisOrderMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="analysisOrder", keyGenerator="redisKeyGenerator")
    @Override
    public List<AnalysisOrder> queryAllObjByExample(AnalysisOrderExample example) {
        return this.analysisOrderMapper.selectByExample(example);
    }

    @Cacheable(value="analysisOrder", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<AnalysisOrder> queryObjByPage(AnalysisOrderExample example) {
        PageView<AnalysisOrder> pageView = example.getPageView();
        pageView.setQueryResult(this.analysisOrderMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Override
	public void saveAnalysisOrder() {
		// 查询出当前月对账单数据
        List<AnalysisOrder> list = this.analysisOrderMapper.selectMonthReport();
        // 硬删除这个月的账单数据
        analysisOrderMapper.deleteByOrderTime();
        
        if (list != null && list.size() > 0) {
        	for (AnalysisOrder item : list) {
        		item.setAuditStates(100);
        		item.setAccountBillStates(400);
        		item.setCreateTime(new Date());
        		item.setUpdateTime(new Date());
        		item.setOrderTime(StatisticAnalysisDateUtil.getMonth());
        	}
        	// 批量插入对账单数据
        	analysisOrderMapper.saveAnalysisOrder(list);
        }
        // 查询出当前月的账单明细
        List<AnalysisOrderProduct> orderProductList = analysisOrderProductMapper.selectLastMonthDetail();
        // 硬删除这个月的账单明细
        analysisOrderProductMapper.deleteByCreateTime();
        if (CollectionUtils.isNotEmpty(orderProductList)) {
        	for (AnalysisOrderProduct item : orderProductList) {
        		item.setCreateTime(new Date());
        	}
        }
        if (orderProductList != null && orderProductList.size() > 0) {
        	// 批量插入账单明细数据
        	analysisOrderProductMapper.saveAnalysisOrderProduct(orderProductList);
        }
        
	}
}