package com.els.runhe.market.service.promotional;

import com.els.base.core.service.BaseService;
import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.entity.promotional.PromotionalCostApplyExample;

public interface PromotionalCostApplyService extends BaseService<PromotionalCostApply, PromotionalCostApplyExample, Integer> {
	/**
	 * 批量修改费用申请
	 * @param record
	 * @param example
	 */
	public void modifyObjByExample(PromotionalCostApply record, PromotionalCostApplyExample example);
	
	/**
     * 根据费用申请编号查询
     * @param promotionalCostNo
     * @return
     */
    public PromotionalCostApply queryByPromotionalCostNo(String promotionalCostNo);
}