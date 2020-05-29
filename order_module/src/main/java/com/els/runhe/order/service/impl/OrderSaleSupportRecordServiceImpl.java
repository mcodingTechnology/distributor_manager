package com.els.runhe.order.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.contract.dao.ContractMapper;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractExample;
import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.service.ContractSaleSupportService;
import com.els.runhe.order.dao.OrderSaleSupportRecordMapper;
import com.els.runhe.order.entity.OrderSaleSupportRecord;
import com.els.runhe.order.entity.OrderSaleSupportRecordExample;
import com.els.runhe.order.entity.SaleAndMarketSupport;
import com.els.runhe.order.service.OrderSaleSupportRecordService;
import com.els.runhe.order.utils.SupportRecordType;
import com.els.runhe.statisticAnalysis.dao.AnalysisFinanceLogMapper;

@Service("defaultOrderSaleSupportRecordService")
public class OrderSaleSupportRecordServiceImpl implements OrderSaleSupportRecordService {
    @Resource
    protected OrderSaleSupportRecordMapper orderSaleSupportRecordMapper;
    
    @Resource
	protected ContractMapper contractMapper;
    
    @Resource
    protected AnalysisFinanceLogMapper analysisFinanceLogMapper;
    
    @Resource
	protected ContractSaleSupportService contractSaleSupportService;
    

    @CacheEvict(value={"orderSaleSupportRecord"}, allEntries=true)
    @Override
    public void addObj(OrderSaleSupportRecord t) {
        this.orderSaleSupportRecordMapper.insertSelective(t);
    }

    @CacheEvict(value={"orderSaleSupportRecord"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.orderSaleSupportRecordMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"orderSaleSupportRecord"}, allEntries=true)
    @Override
    public void modifyObj(OrderSaleSupportRecord t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderSaleSupportRecordMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="orderSaleSupportRecord", keyGenerator="redisKeyGenerator")
    @Override
    public OrderSaleSupportRecord queryObjById(String id) {
        return this.orderSaleSupportRecordMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="orderSaleSupportRecord", keyGenerator="redisKeyGenerator")
    @Override
    public List<OrderSaleSupportRecord> queryAllObjByExample(OrderSaleSupportRecordExample example) {
        return this.orderSaleSupportRecordMapper.selectByExample(example);
    }

    @Cacheable(value="orderSaleSupportRecord", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<OrderSaleSupportRecord> queryObjByPage(OrderSaleSupportRecordExample example) {
        PageView<OrderSaleSupportRecord> pageView = example.getPageView();
        pageView.setQueryResult(this.orderSaleSupportRecordMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Cacheable(value="orderSaleSupportRecord", keyGenerator="redisKeyGenerator")
	@Override
	public SaleAndMarketSupport calculateByOrderId(String companyId) {
    	SaleAndMarketSupport orderSupportInfo = new SaleAndMarketSupport();
    	
    	BigDecimal saleTotalQuota = this.querySumRefund(companyId, SupportRecordType.SALE_SUPPORT_INCREASE.getCode());
		orderSupportInfo.setSaleSupportTotalQuota(saleTotalQuota);
		
		BigDecimal saleUsedQuota = this.querySumRefund(companyId, SupportRecordType.SALE_SUPPORT_DECREASE.getCode());
		orderSupportInfo.setSaleSupportUsedQuota(saleUsedQuota);
		
		orderSupportInfo.setSaleSupportQuota(saleTotalQuota.subtract(saleUsedQuota));
		
		BigDecimal marketTotalQuota = this.querySumRefund(companyId, SupportRecordType.MARKET_SUPPORT_INCREASE.getCode());
		orderSupportInfo.setMarketSupportTotalQuota(marketTotalQuota);
		
		BigDecimal marketUsedQuota = this.querySumRefund(companyId, SupportRecordType.MARKET_SUPPORT_DECREASE.getCode());
		orderSupportInfo.setMarketSupportUsedQuota(marketUsedQuota);
		
		orderSupportInfo.setMarketSupportQuota(marketTotalQuota.subtract(marketUsedQuota));
		
		return orderSupportInfo;
	}
    
    private BigDecimal querySumRefund(String companyId, String typeCode){
    	OrderSaleSupportRecordExample example = new OrderSaleSupportRecordExample();
		example.createCriteria()
		    .andPurCompanyIdEqualTo(companyId)
		    .andTypeEqualTo(typeCode);
		
		//总额度
		BigDecimal quota = this.orderSaleSupportRecordMapper.sumRefundByExample(example);
		if (quota == null) {
			quota = BigDecimal.ZERO;
		}
    	
		return quota;
    }

	@Override
	public SaleAndMarketSupport saleSupportRecordByCompanyId(String purCompanyId) {
		
		if(StringUtils.isEmpty(purCompanyId)){
			throw new CommonException(String.format("经销商id为空"));
		}
		SaleAndMarketSupport saleAndMarketSupport = new SaleAndMarketSupport();
		// 查询合同  
		
		Date now = new Date(); // 当前时间
		ContractExample example = new ContractExample();
		ContractExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andPartyBIdEqualTo(purCompanyId);
		// criteria.andStatusEqualTo(ContractStatus.Valid.getId()); // 有效状态
		criteria.andStartDateLessThanOrEqualTo(now).andEndDateGreaterThanOrEqualTo(now); // 当前时间在有效区间内
		List<Contract> list = this.contractMapper.selectByExample(example);
		
		if (CollectionUtils.isEmpty(list)) {
			setSaleAndMarketSupport(saleAndMarketSupport);
		}else if (list.size() > 0) {
			// 查询对应的回款额度
			String aoumt = this.analysisFinanceLogMapper.queryAmountByCompanyId(purCompanyId);
			if(StringUtils.isEmpty(aoumt)){
				setSaleAndMarketSupport(saleAndMarketSupport);
			}else if (Double.parseDouble(aoumt) == 0){
				setSaleAndMarketSupport(saleAndMarketSupport);
			}else if (Double.parseDouble(aoumt) > 0){
				Contract contract = list.get(0);
				if(contract.getMarketExpenseRate() > 0){
					// 市场支持额度
					BigDecimal aDecimal = new BigDecimal(aoumt);
					saleAndMarketSupport.setMarketSupportTotalQuota(aDecimal.divide(new BigDecimal(contract.getMarketExpenseRate()), 2, RoundingMode.HALF_UP));
					saleAndMarketSupport.setMarketSupportUsedQuota(new BigDecimal(0));
					saleAndMarketSupport.setMarketSupportQuota(saleAndMarketSupport.getMarketSupportTotalQuota().subtract(saleAndMarketSupport.getMarketSupportUsedQuota()));
					
					saleAndMarketSupport.setSaleSupportQuota(new BigDecimal(0));
					saleAndMarketSupport.setSaleSupportUsedQuota(new BigDecimal(0));
					saleAndMarketSupport.setMarketSupportUsedQuota(new BigDecimal(0));
					if(StringUtils.isNotEmpty(contract.getId())){
						// 销售支持
						List<ContractSaleSupport> saleSupportList = contractSaleSupportService.getSaleSupportListByContractId(contract.getId());
						Double support = 0.0;
						for(ContractSaleSupport contractSaleSupport : saleSupportList){
							// 大于等于最小值  小于等于最大值
							if(contractSaleSupport.getSerialNum() < 4){
								if(Double.parseDouble(aoumt) >= contractSaleSupport.getRefundMin() && Double.parseDouble(aoumt) <= contractSaleSupport.getRefundMax()){
									support = contractSaleSupport.getSupportRate();
								}
							}else if (Double.parseDouble(aoumt) > contractSaleSupport.getRefundMin()) {
								support = contractSaleSupport.getSupportRate();
							}
						}
						if(support > 0){
							saleAndMarketSupport.setSaleSupportTotalQuota(aDecimal.divide(new BigDecimal(support), 2, RoundingMode.HALF_UP));
							saleAndMarketSupport.setMarketSupportQuota(saleAndMarketSupport.getSaleSupportTotalQuota().subtract(saleAndMarketSupport.getSaleSupportUsedQuota()));
						}
						
					}
				}else {
					saleAndMarketSupport.setMarketSupportQuota(new BigDecimal(0));
					saleAndMarketSupport.setMarketSupportTotalQuota(new BigDecimal(0));
					saleAndMarketSupport.setMarketSupportUsedQuota(new BigDecimal(0));
				}
			}
		}
		return saleAndMarketSupport;
	}

	private void setSaleAndMarketSupport(SaleAndMarketSupport saleAndMarketSupport) {
		saleAndMarketSupport.setMarketSupportQuota(new BigDecimal(0));
		saleAndMarketSupport.setMarketSupportTotalQuota(new BigDecimal(0));
		saleAndMarketSupport.setMarketSupportUsedQuota(new BigDecimal(0));
		saleAndMarketSupport.setSaleSupportQuota(new BigDecimal(0));
		saleAndMarketSupport.setSaleSupportTotalQuota(new BigDecimal(0));
		saleAndMarketSupport.setSaleSupportUsedQuota(new BigDecimal(0));
	}
}