package com.els.runhe.order.ruleengine.command;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.els.base.core.exception.CommonException;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.service.ContractSaleSupportService;
import com.els.runhe.contract.service.ContractService;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderSaleSupportRecord;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.service.OrderSaleSupportRecordService;
import com.els.runhe.order.utils.SupportRecordType;

/**
 * 添加销售支持，市场支持的变化记录
 * @author hzy
 *
 */
public class AddSupportRecordCommand implements OrderCommand {
	
	private static Logger logger = LoggerFactory.getLogger(AddSupportRecordCommand.class);

	private Order order;

	public AddSupportRecordCommand(Order order) {
		this.order = order;
	}

	@Override
	public void execute(OrderRuleEngine context) {

		ContractService contractService = SpringContextHolder.getOneBean(ContractService.class);
		ContractSaleSupportService contractSaleSupportService = SpringContextHolder
				.getOneBean(ContractSaleSupportService.class);
		OrderSaleSupportRecordService supportRecordService = SpringContextHolder
				.getOneBean(OrderSaleSupportRecordService.class);

		//1、查询供应商的有效合同
		Contract contract = contractService.getValidContractByPartyB(order.getPurCompanyId());
		if (contract == null) {
			throw new CommonException("该经销商还没有找到有效的合同");
		}
		
		//2、根据合同和订单金额，获取销售支持的额度
		ContractSaleSupport support = contractSaleSupportService.getSaleSupportByActualSales(contract.getId(),
				order.getAmountPay().doubleValue());
		
		if (support != null) {
			// 根据订单的金额，添加记录，销售支持额度的增加
			this.addSaleSupportIncrease(contract, support, supportRecordService);
			this.addMarketIncrease(contract, support, supportRecordService);
		}

		//3、 根据订单中，添加记录，消耗的销售支持额度，
		this.addSaleSupportDecrease(contract, order, supportRecordService);
		this.addMarketDecrease(contract, order, supportRecordService);

	}

	/**
	 * 根据订单中，使用的市场支持额度，减少额度
	 * @param contract
	 * @param order
	 * @param supportRecordService
	 */
	private void addMarketDecrease(Contract contract, Order order,
			OrderSaleSupportRecordService supportRecordService) {
		
		if (order.getApplyMarketSupport() == null
				|| order.getApplyMarketSupport().equals(BigDecimal.ZERO)) {
			return;
		}

		OrderSaleSupportRecord marketSupport = new OrderSaleSupportRecord();
		marketSupport.setContractId(contract.getId());
		marketSupport.setCreateTime(new Date());
		marketSupport.setOrderId(order.getId());
		marketSupport.setOrderNo(order.getOrderNo());
		marketSupport.setPurCompanyId(order.getPurCompanyId());
		marketSupport.setOrderAmountPay(order.getAmountPay());
		marketSupport.setRefund(order.getApplyMarketSupport());
		marketSupport.setSupportRate(new BigDecimal(contract.getMarketExpenseRate()));
		marketSupport.setRefund(order.getApplyMarketSupport());
		marketSupport.setType(SupportRecordType.MARKET_SUPPORT_DECREASE.getCode());
		supportRecordService.addObj(marketSupport);
	}
	
	/**
	 * 根据订单中，使用的销售支持额度，减少销售支持
	 * @param contract
	 * @param order
	 * @param supportRecordService
	 */
	private void addSaleSupportDecrease(Contract contract, Order order,
			OrderSaleSupportRecordService supportRecordService) {
		
		if (order.getApplySaleSupport() == null
				|| order.getApplySaleSupport().equals(BigDecimal.ZERO)) {
			return;
		}
		
		OrderSaleSupportRecord saleSupport = new OrderSaleSupportRecord();
		saleSupport.setContractId(contract.getId());
		saleSupport.setCreateTime(new Date());
		saleSupport.setOrderId(order.getId());
		saleSupport.setOrderNo(order.getOrderNo());
		saleSupport.setPurCompanyId(order.getPurCompanyId());

		saleSupport.setRefund(order.getApplySaleSupport());
		saleSupport.setType(SupportRecordType.SALE_SUPPORT_DECREASE.getCode());
		supportRecordService.addObj(saleSupport);
	}

	/**
	 * 根据订单的金额，和合同里面额度阶梯，增加市场支持额度
	 * @param contract
	 * @param order
	 * @param supportRecordService
	 */
	private void addMarketIncrease(Contract contract, ContractSaleSupport support,
			OrderSaleSupportRecordService supportRecordService) {
		
		if (contract == null
				|| contract.getMarketExpenseRate() == null
				|| contract.getMarketExpenseRate().equals(0.0)) {
			logger.debug("合同中没有配置市场推广费用比率，不用添加市场推广费用");
			return;
		}

		OrderSaleSupportRecord marketSupport = new OrderSaleSupportRecord();
		marketSupport.setContractId(contract.getId());
		marketSupport.setCreateTime(new Date());
		marketSupport.setOrderAmountPay(order.getAmountPay());
		marketSupport.setOrderId(order.getId());
		marketSupport.setOrderNo(order.getOrderNo());
		marketSupport.setPurCompanyId(order.getPurCompanyId());

		marketSupport.setSupportRate(new BigDecimal(contract.getMarketExpenseRate()));

		marketSupport.setRefund(order.getAmountPay().multiply(marketSupport.getSupportRate()));
		marketSupport.setType(SupportRecordType.MARKET_SUPPORT_INCREASE.getCode());
		supportRecordService.addObj(marketSupport);
	}

	/**
	 * 根据订单的金额，和合同里面额度阶梯，增加销售支持额度
	 * @param contract
	 * @param order
	 * @param supportRecordService
	 */
	private void addSaleSupportIncrease(Contract contract, ContractSaleSupport support,
			OrderSaleSupportRecordService supportRecordService) {
		
		if (support == null
				|| support.getSupportRate() == null
				|| support.getSupportRate().equals(0.0)) {
			logger.debug("合同中没有配置销售支持比率，不用添加销售支持费用");
			return;
		}
		
		OrderSaleSupportRecord saleSupport = new OrderSaleSupportRecord();
		saleSupport.setContractId(contract.getId());
		saleSupport.setCreateTime(new Date());
		saleSupport.setOrderAmountPay(order.getAmountPay());
		saleSupport.setOrderId(order.getId());
		saleSupport.setOrderNo(order.getOrderNo());
		saleSupport.setPurCompanyId(order.getPurCompanyId());

		if (support.getRefundMax() != null) {
			saleSupport.setRefundMax(new BigDecimal(support.getRefundMax()));
		}
		if (support.getRefundMin() != null) {
			saleSupport.setRefundMin(new BigDecimal(support.getRefundMin()));
		}
		saleSupport.setSupportRate(new BigDecimal(support.getSupportRate()));

		saleSupport.setRefund(order.getAmountPay().multiply(saleSupport.getSupportRate()));
		saleSupport.setType(SupportRecordType.SALE_SUPPORT_INCREASE.getCode());
		supportRecordService.addObj(saleSupport);

	}

}
