package com.els.runhe.market.service.train;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.entity.train.MarketTrainApplyExample;

public interface MarketTrainApplyService extends BaseService<MarketTrainApply, MarketTrainApplyExample, Integer> {

	/**
	 * 批量修改市场培训申请
	 * @param record
	 * @param example
	 */
	public void modifyObjByExample(MarketTrainApply record, MarketTrainApplyExample example);
	
	/**
	 * 根据培训申请ID查询
	 * @param trainApplyId
	 * @return
	 */
	public MarketTrainApply queryByTrainApplyId(String trainApplyId);
	
	public List<String> returnAreaList();
}