package com.els.runhe.returned.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.codegenerator.service.GenerateCodeService;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.returned.dao.OrderReturnMapper;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.entity.OrderReturnExample;
import com.els.runhe.returned.entity.OrderReturnProducts;
import com.els.runhe.returned.entity.OrderReturnProductsExample;
import com.els.runhe.returned.service.OrderReturnProductsService;
import com.els.runhe.returned.service.OrderReturnService;

@Service("defaultOrderReturnService")
public class OrderReturnServiceImpl implements OrderReturnService {
    @Resource
    protected OrderReturnMapper orderReturnMapper;
    
    @Resource
    protected OrderReturnProductsService orderReturnProductsServiceImpl;

    private static final String RETURN_CODE_GENERATE = "ORDER_RETURN_CODE";
    protected static GenerateCodeService generateCodeService  = SpringContextHolder.getOneBean(GenerateCodeService.class);
    
    @CacheEvict(value={"orderReturn"}, allEntries=true)
    @Override
    public void addObj(OrderReturn t) {
    	//退货单编号生成规则(年月日时分秒) 例如：R2017111300000001
    	String code =generateCodeService.getNextCode(RETURN_CODE_GENERATE);
    	t.setOrderReturnNo(code);
    	
    	if(CollectionUtils.isEmpty(t.getOrderReturnItems())){
    		throw new CommonException("退货单行不能为空！");
    	}
        this.orderReturnMapper.insertSelective(t);
        
        //新增退货单关联表
        for(OrderReturnProducts orderReturnProducts:t.getOrderReturnItems()){
        	orderReturnProducts.setOrderReturnNo(t.getOrderReturnNo());
        	this.orderReturnProductsServiceImpl.addObj(orderReturnProducts);
        }
        //启动审批
        //SpringContextHolder.getApplicationContext().publishEvent(new OrderReturnCreatedEvent(t));
    }

    @CacheEvict(value={"orderReturn"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.orderReturnMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"orderReturn"}, allEntries=true)
    @Override
	public void deleteObjByOrderReturnNo(String orderReturnNo) {
    	this.orderReturnMapper.deleteObjByOrderReturnNo(orderReturnNo);
    	//删除退货单关联表
    	this.orderReturnProductsServiceImpl.deleteObjByOrderReturnNo(orderReturnNo);
	}
    
    @CacheEvict(value={"orderReturn"}, allEntries=true)
    @Override
    public void modifyObj(OrderReturn t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        
        this.orderReturnMapper.updateByPrimaryKeySelective(t);
        
      //修改退货单关联表
        if(CollectionUtils.isNotEmpty(t.getOrderReturnItems())){
            for(OrderReturnProducts orderReturnProducts:t.getOrderReturnItems()){
            	//若产品信息中退货单编号为空，则新增产品信息
            	if(StringUtils.isEmpty(orderReturnProducts.getOrderReturnNo())){
            		orderReturnProducts.setOrderReturnNo(t.getOrderReturnNo());
            		this.orderReturnProductsServiceImpl.addObj(orderReturnProducts);
            	}else{
            		this.orderReturnProductsServiceImpl.modifyObj(orderReturnProducts);
            	}
            }
    	}
    }

    @Cacheable(value="orderReturn", keyGenerator="redisKeyGenerator")
    @Override
    public OrderReturn queryObjById(Integer id) {
        return this.orderReturnMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="orderReturn", keyGenerator="redisKeyGenerator")
    @Override
    public List<OrderReturn> queryAllObjByExample(OrderReturnExample example) {
        return this.orderReturnMapper.selectByExample(example);
    }

    @Cacheable(value="orderReturn", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<OrderReturn> queryObjByPage(OrderReturnExample example) {
        PageView<OrderReturn> pageView = example.getPageView();
        
        List<OrderReturn> list = this.orderReturnMapper.selectByExampleByPage(example);
        //退货单查询行明细
        for(int i=0;CollectionUtils.isNotEmpty(list)&&i<list.size();i++){
        	this.setItems(list.get(i));
        }
        pageView.setQueryResult(list);
        return pageView;
    }
    
    /**
     * 将退货产品信息关联到退货单
     * @param orderReturn
     */
    private void setItems(OrderReturn orderReturn){
    	if(StringUtils.isBlank(orderReturn.getOrderReturnNo())){
    		return;
    	}
    	//根据退货单号查询退货单行明细
    	OrderReturnProductsExample OrderReturnProductsExample = new OrderReturnProductsExample();
    	OrderReturnProductsExample.createCriteria().andOrderReturnNoEqualTo(orderReturn.getOrderReturnNo());
    	orderReturn.setOrderReturnItems(this.orderReturnProductsServiceImpl.queryAllObjByExample(OrderReturnProductsExample));
    }

    @CacheEvict(value={"orderReturn"}, allEntries=true)
	@Override
	public void modifyObjByExample(OrderReturn record, OrderReturnExample OrderReturnExample) {
		this.orderReturnMapper.updateByExampleSelective(record, OrderReturnExample);
	}

	@Cacheable(value="orderReturn", keyGenerator="redisKeyGenerator")
	@Override
	public OrderReturn queryByOrderReturnNo(String orderReturnNo) {
		OrderReturn OrderReturn = this.orderReturnMapper.selectByOrderReturnNo(orderReturnNo);
		return OrderReturn;
	}
}