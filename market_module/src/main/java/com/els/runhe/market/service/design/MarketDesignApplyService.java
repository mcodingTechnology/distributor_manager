package com.els.runhe.market.service.design;

import com.els.base.core.service.BaseService;
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.entity.design.MarketDesignApplyExample;

public interface MarketDesignApplyService extends BaseService<MarketDesignApply, MarketDesignApplyExample, Integer> {

	/**
	 * 批量修改平面设计申请
	 * @param record
	 * @param example
	 */
	public void modifyObjByExample(MarketDesignApply record, MarketDesignApplyExample example);
	
	/**
     * 根据平面设计申请编号查询
     * @param orderReturnNo
     * @return
     */
    public MarketDesignApply queryByDesignApplyId(String designApplyId);
}