package com.els.runhe.warehouse.event.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.component.ProductComponent;
import com.els.runhe.warehouse.data.Status;
import com.els.runhe.warehouse.data.StockConstant;
import com.els.runhe.warehouse.data.StockOptType;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckList;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockKey;
import com.els.runhe.warehouse.model.StockOpt;
import com.els.runhe.warehouse.service.StockCheckListService;
import com.els.runhe.warehouse.service.StockCheckService;
import com.els.runhe.warehouse.service.StockService;
import com.els.runhe.warehouse.service.WarehouseService;
import com.els.runhe.warehouse.util.IdUtil;

@Component
public class StockCheckFinishedListener implements ApplicationListener<TaskOperateEvent> {
	
	private static Logger logger = LoggerFactory.getLogger(StockCheckFinishedListener.class);
	
	@Resource
	protected StockCheckService stockCheckService;
	
	@Resource
	protected StockCheckListService stockCheckListService;

	@Resource
	private UserService userService;
	
	@Resource
	protected ProductComponent productComponent;
	
	@Resource
	protected WarehouseService warehouseService;
	
	@Resource
	protected StockService stockService;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if (!(StockConstant.STOCK_CHECK_APPROVE_PROCESS_ID.equals(processKey) || StockConstant.STORAGE_APPROVE_PROCESS_ID.equals(processKey))) {
			return;
		}
		
		String id = (String) event.getCurrentProcess().getProcessVariables().get(ProcessVariableNameEnum.BUSINESS_ID.getVarName());
		if (StringUtils.isBlank(id)) {
			throw new CommonException("流程执行失败，流程中id的参数为空");
		}
		
		StockCheck stockCheck = this.stockCheckService.queryObjById(id);
		if (stockCheck == null) {
			throw new CommonException("流程执行失败，流程中id在数据库没有数据");
		}
		List<StockCheckList> stockCheckList= stockCheckListService.queryObjByStockCheckId(id);
		
		StockCheck temp = new StockCheck();
		temp.setId(id);
		
		if (event.isPass()) {
			// 更新库存
			List<Integer> productIdList = new ArrayList<>();
			String warehouseId = stockCheck.getWarehouseId();
			warehouseId = (StringUtils.isBlank(warehouseId)) ? "" : warehouseId;
			List<StockKey> stockKeyList = new ArrayList<>();
			
			for (StockCheckList detail : stockCheckList) {
				String productId = detail.getProductId();
				if (StringUtils.isBlank(productId) || detail.getAmount() < 0) {
					continue;
				}
				StockKey stockKey = new StockKey();
				stockKey.setProductId(productId);
				stockKey.setWarehouseId(warehouseId);
				stockKeyList.add(stockKey);
				productIdList.add(IdUtil.change(productId));
			}
			if (CollectionUtils.isEmpty(productIdList)) {
				return;
			}
			Map<String, Stock> stockMap = productComponent.transferStockToMapByKeys(stockKeyList);
			// 产品信息处理
			Map<String, Product> productMap = productComponent.transferIdsToMap(productIdList);
			if (null == productMap || productMap.isEmpty()) {
				return;
			}
			Warehouse warehouse = warehouseService.queryObjById(stockCheck.getWarehouseId());
			for (StockCheckList detail : stockCheckList) {
				String productId = detail.getProductId();
				Product product = productMap.get(productId);
				if (null == product) {
					continue;
				}
				// 更新库存(同时会产生库存流水单)    -2018-01-21  改为提交审批
				StockOpt stockOpt = new StockOpt();
				stockOpt.setWarehouseId(warehouseId);
				stockOpt.setProductId(productId);
				stockOpt.setAmount(detail.getAmount());
				stockOpt.setOptType(StockOptType.Check.getId());
				stockService.optStockByBatch(stockOpt, warehouse, product, stockMap);
			}
			temp.setApprovalStatus(Status.Pass.getId());
			stockCheckService.modifyObj(temp);
			logger.info("盘点单审批结束||入库单审批结束，更改状态为[{}]", temp.getApprovalStatus());
		}else {
			//如果审批没通过
			temp.setApprovalStatus(Status.No_Pass.getId());
			stockCheckService.modifyObj(temp);
			logger.info("盘点单审批结束||入库单审批结束，更改状态为[{}]", temp.getApprovalStatus());
			
		}
		
		
	}

}
