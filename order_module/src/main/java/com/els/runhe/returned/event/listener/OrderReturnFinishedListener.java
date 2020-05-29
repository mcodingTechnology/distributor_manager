package com.els.runhe.returned.event.listener;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.exception.CommonException;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.utils.ApproveStatusEnum;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.event.OrderReturnStatusEnum;
import com.els.runhe.returned.service.OrderReturnService;

@Component
public class OrderReturnFinishedListener implements ApplicationListener<TaskOperateEvent>{

	private static final Logger logger = LoggerFactory.getLogger(OrderReturnFinishedListener.class);
	
	@Resource
	protected OrderReturnService orderReturnService;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if(!StartOrderReturnProcessListener.ORDER_RETURN_PROCESS_KEY.equals(processKey)){
			return;
		}
		
		if(!event.isFinished()){
			return;
		}
		
		String orderReturnNo = (String)event.getCurrentProcess().getProcessVariables().get("orderReturnNo");//退货单编号
		//Integer id = (Integer) event.getCurrentProcess().getProcessVariables().get(ProcessVariableNameEnum.BUSINESS_ID.getVarName());
		
		if(StringUtils.isBlank(orderReturnNo)){
			throw new CommonException("流程执行失败，流程中的orderReturnNo的参数为空！");
		}
		
		OrderReturn orderReturn = this.orderReturnService.queryByOrderReturnNo(orderReturnNo);
		if(orderReturn == null){
			throw new CommonException("流程执行失败，流程中id在数据库没有数据");
		}
		if (event.isPass()) {
			orderReturn.setApprovalStatus(ApproveStatusEnum.PASS.getValue());
			//审批通过，修改退货单状态
			orderReturn.setOrderReturnStatus(OrderReturnStatusEnum.UN_DELIVERED.getCode());
		}else {
			orderReturn.setApprovalStatus(ApproveStatusEnum.REJECT.getValue());
			//审批拒绝，退货单状态归0
			//orderReturn.setOrderReturnStatus(OrderReturnStatusEnum.UN_ADD.getCode());
		}
		
		orderReturnService.modifyObj(orderReturn);
		logger.info("退货单审批通过，更改状态为通过[{}]", ApproveStatusEnum.PASS.getValue());
	}

}
