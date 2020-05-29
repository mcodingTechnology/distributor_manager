package com.els.runhe.market.event.promotional.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.company.entity.Company;
import com.els.base.company.service.CompanyService;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.event.promotional.PromotionalCostApplyEvent;
import com.els.runhe.market.event.promotional.PromotionalCostStatusEnum;
import com.els.runhe.market.service.promotional.PromotionalCostApplyService;

@Component("startPromotionalCostProcessListener")
public class StartPromotionalCostProcessListener  implements ApplicationListener<PromotionalCostApplyEvent>{

	private static final Logger logger =LoggerFactory.getLogger(StartPromotionalCostProcessListener.class);
	public static final String PROMOTIONAL_COST_PROCESS_KEY ="promotional_costs_approve_process";
	
	@Resource
	protected WorkFlowService workFlowService;
	
	@Resource
	protected PromotionalCostApplyService promotionalCostApplyService;
	
	@Resource
    protected CompanyService companyService;
	
	@Override
	public void onApplicationEvent(PromotionalCostApplyEvent event) {
		PromotionalCostApply promotionalCostApply = (PromotionalCostApply) event.getSource();
		
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), promotionalCostApply.getUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), promotionalCostApply.getId());
		Company company = this.companyService.queryObjById(promotionalCostApply.getAgents());
		String companyName = company.getCompanyFullName();
		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), companyName);
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "促销活动费用申请审批流程");
		//费用申请信息id
		processMap.put("promotionalCostNo", promotionalCostApply.getPromotionalCostNo());
		//修改费用申请单状态
		promotionalCostApply.setStatus(PromotionalCostStatusEnum.UN_CONFIRM.getCode());
		promotionalCostApply.setUpdateTime(new Date());
		
		this.workFlowService.startProcess(PROMOTIONAL_COST_PROCESS_KEY, promotionalCostApply.getPromotionalCostNo(), processMap);
		
		this.promotionalCostApplyService.modifyObj(promotionalCostApply);
		logger.info("促销活动费用申请成功开启审批流程");
	}

}
