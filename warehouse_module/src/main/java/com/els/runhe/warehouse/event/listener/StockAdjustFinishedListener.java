package com.els.runhe.warehouse.event.listener;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.product.dao.product.ProductMapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.component.ProductComponent;
import com.els.runhe.warehouse.data.AmountType;
import com.els.runhe.warehouse.data.Status;
import com.els.runhe.warehouse.data.StockConstant;
import com.els.runhe.warehouse.data.StockOptType;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustList;
import com.els.runhe.warehouse.model.StockOpt;
import com.els.runhe.warehouse.service.StockAdjustListService;
import com.els.runhe.warehouse.service.StockAdjustService;
import com.els.runhe.warehouse.service.StockService;
import com.els.runhe.warehouse.service.WarehouseService;
import com.els.runhe.warehouse.util.IdUtil;

@Component
public class StockAdjustFinishedListener implements ApplicationListener<TaskOperateEvent> {
	
	private static Logger logger = LoggerFactory.getLogger(StockAdjustFinishedListener.class);
	
	@Resource
	protected StockAdjustService stockAdjustService;
	
	@Resource
	protected StockAdjustListService stockAdjustListService;

	@Resource
	private UserService userService;
	
	@Resource
	protected ProductComponent productComponent;
	
	@Resource
	protected WarehouseService warehouseService;
	
	@Resource
	protected StockService stockService;
	
	@Resource
	protected ProductMapper productMapper;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if (!StockConstant.STOCK_ADJUST_APPROVE_PROCESS_ID.equals(processKey)) {
			return;
		}
		
		String id = (String) event.getCurrentProcess().getProcessVariables().get(ProcessVariableNameEnum.BUSINESS_ID.getVarName());
		if (StringUtils.isBlank(id)) {
			throw new CommonException("流程执行失败，流程中id的参数为空");
		}
		
		StockAdjust stockAdjust = this.stockAdjustService.queryObjById(id);
		if (stockAdjust == null) {
			throw new CommonException("流程执行失败，流程中id在数据库没有数据");
		}
		List<StockAdjustList> stockAdjustLists = stockAdjustListService.queryListByStockAdjustId(id);
		
		StockAdjust temp = new StockAdjust();
		temp.setId(id);
		
		if (event.isPass()) {
			// 更新库存
			for (StockAdjustList stockCheckList : stockAdjustLists) {
				Product product = productMapper.selectByPrimaryKey(IdUtil.change(stockCheckList.getProductId()));
				if (null == product) {
					throw new CommonException("调整清单产品不存在");
				}
				Stock stock = stockService.getStockInfoByProduct(stockAdjust.getWarehouseId(), stockCheckList.getProductId());
				if (null == stock) {
					throw new CommonException("调整清单产品库存记录不存在");
				}
				if (AmountType.Minus.getId().equals(stockCheckList.getAdjustType())) {
					// 减少库存后库存不得小于0
					Integer originAmount = stock.getAmount();
					if (originAmount - stockCheckList.getAmount() < 0) {
						throw new CommonException("调整清单产品库存调整后小于0");
					}
				}
				StockOpt stockOpt = new StockOpt();
				stockOpt.setProductId(stockCheckList.getProductId());
				stockOpt.setWarehouseId(stockAdjust.getWarehouseId());
				stockOpt.setAmount(stock.getAmount());
				stockOpt.setAmountType(stockCheckList.getAdjustType());
				stockOpt.setOptType(StockOptType.Adjust.getId());
				stockService.optStock(stockOpt);
			}
			
			temp.setStatus(Status.Pass.getId());
			stockAdjustService.modifyObj(temp);
			logger.info("调整单审批结束，更改状态为[{}]", temp.getStatus());
		}else {
			//如果审批没通过
			temp.setStatus(Status.No_Pass.getId());
			stockAdjustService.modifyObj(temp);
			logger.info("调整单审批结束，更改状态为[{}]", temp.getStatus());
			
		}
		
		
	}

}
