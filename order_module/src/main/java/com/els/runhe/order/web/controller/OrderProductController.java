package com.els.runhe.order.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRef;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.service.product.ProductService;
import com.els.runhe.product.service.productCategoryRef.ProductCategoryRefService;
import com.els.runhe.product.service.productPrice.ProductPriceService;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockExample;
import com.els.runhe.warehouse.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="订单-行项目")
@Controller
@RequestMapping("orderProduct")
public class OrderProductController {
    @Resource
    protected OrderProductService orderProductService;
    
    @Resource
    protected ProductPriceService productPriceService;
    
    @Resource
    protected ProductCategoryRefService productCategoryRefService;
    
    @Resource
    protected ProductService productService;
    
    @Resource
    protected StockService stockService;

    @ApiOperation(httpMethod="POST", value="根据产品数量，生成订单行项目")
    @RequestMapping("service/preview")
    @ResponseBody
    public ResponseResult<List<OrderProduct>> preview(@RequestBody List<OrderProduct> orderProductList) {
    	if (CollectionUtils.isEmpty(orderProductList)) {
			throw new CommonException("参数不能为空");
		}
    	
    	for(OrderProduct orderProduct: orderProductList){
    		if (orderProduct.getProductId() == null || orderProduct.getProductId() <= 0) {
    			throw new CommonException("产品id异常");
			}
    		
    		if (orderProduct.getNums() == null || orderProduct.getNums() <= 0) {
    			throw new CommonException("产品数量异常");
    		}
    		if (StringUtils.isBlank(orderProduct.getCompanyId())) {
    			throw new CommonException("要货方的id不能为空");
    		}
    		
    		ProductPrice productPrice = productPriceService.queryByProductIdAndNum(orderProduct.getProductId(), orderProduct.getNums(), orderProduct.getCompanyId());
    		if (productPrice == null) {
    	    	throw new CommonException("产品id["+orderProduct.getProductId()+"],还没有设置供货价");
			}
    		
    		orderProduct.setAmountTotal(productPrice.getPrice().multiply(new BigDecimal(orderProduct.getNums())));
    		orderProduct.setCompanyId(productPrice.getCompanyId());
    		orderProduct.setCompanyName(productPrice.getCompanyName());
    		orderProduct.setProductSupplyPrice(productPrice.getPrice());
    		orderProduct.setProductPriceForNextDealer(productPrice.getPriceForNextDealer());
    		
    		StockExample stockExample = new StockExample();
    		stockExample.createCriteria().andProductIdEqualTo(String.valueOf(orderProduct.getProductId()));
    		List<Stock> stockList = this.stockService.queryAllObjByExample(stockExample);
    		if (CollectionUtils.isNotEmpty(stockList)) {
				orderProduct.setProductStock(stockList.get(0).getAmount());
			}
    		
    		if (StringUtils.isBlank(orderProduct.getProductName())) {
				Product product = this.productService.queryObjById(orderProduct.getProductId());
				if (product == null) {
					throw new CommonException("该产品不存在");
				}
				orderProduct.setProductName(product.getProductName());
				orderProduct.setProductCode(product.getBarCode());
				orderProduct.setProductSpec(product.getSpec());
				orderProduct.setProductPrice(product.getOriginPrice());
				orderProduct.setCategoryId(product.getCategoryId());
				orderProduct.setCategoryName(product.getCategoryName());
			}
    	}
    	
    	return ResponseResult.success(orderProductList);
    }
    
    @ApiOperation(httpMethod="POST", value="根据产品分类，生成订单行项目")
    @ApiImplicitParams({ 
	    @ApiImplicitParam( name = "categroyId",required = false,value = "分类id", paramType = "query", dataType = "int"),  
	    @ApiImplicitParam( name = "companyId", required = false, value = "经销商id", paramType = "query", dataType = "String" )  
    }) 
    @RequestMapping("service/previewForCategroyId")
    @ResponseBody
    public ResponseResult<List<OrderProduct>> previewForCategroyId(@RequestParam int categroyId, @RequestParam(required=true) String companyId) {
    	
//    	ProductCategoryRefExample refExample = new ProductCategoryRefExample();
//    	refExample.createCriteria().andCategoryIdEqualTo(categroyId);
//    	
//    	List<ProductCategoryRef> refList = productCategoryRefService.queryAllObjByExample(refExample);
    	// 查询出库存数量大于0，并且大于最小安全库存
    	List<ProductCategoryRef> refList = productCategoryRefService.queryProductCategory(categroyId);
    	if (CollectionUtils.isEmpty(refList)) {
			return ResponseResult.success(null);
		}
    	
    	List<OrderProduct> orderProductList = new ArrayList<>(refList.size());
    	for(ProductCategoryRef ref: refList){
    		
//    		ProductPrice productPrice = productPriceService.queryByProductIdAndNum(ref.getProductId(), 1, companyId);
    		ProductPrice productPrice = productPriceService.queryLowestPrice(ref.getProductId(), companyId);
    		
    		if (productPrice == null ) {
				continue;
			}
    		
    		if (productPrice.getPrice()==null) {
				throw new CommonException("产品id["+ref.getProductId()+"],还没有设置供货价");
			}
    		
    		Product product = this.productService.queryObjById(ref.getProductId());
    		if (product == null) {
				continue;
			}
    		
    		OrderProduct orderProduct = new OrderProduct();
    		
    		orderProduct.setCompanyId(productPrice.getCompanyId());
    		orderProduct.setCompanyName(productPrice.getCompanyName());
    		
    		orderProduct.setCategoryId(categroyId);
    		orderProduct.setCategoryName(ref.getCategoryName());
    		
    		orderProduct.setProductId(ref.getProductId());
    		orderProduct.setProductName(product.getProductName());
			orderProduct.setProductCode(product.getNumberCode());
			orderProduct.setProductImg(product.getCoverImg());
			orderProduct.setProductSpec(product.getSpec());

			orderProduct.setProductPrice(product.getOriginPrice());
			orderProduct.setProductStock(ref.getProductStock());
			
			orderProduct.setProductUnit(productPrice.getProductUnit());
    		orderProduct.setProductSupplyPrice(productPrice.getPrice());
    		orderProduct.setProductPriceForNextDealer(productPrice.getPriceForNextDealer());
    		
    		orderProduct.setNums(0);
    		orderProduct.setAdviceNum(productPrice.getNumFrom() == null ? 1 : productPrice.getNumFrom());
    		orderProduct.setAmountTotal(productPrice.getPrice().multiply(new BigDecimal(orderProduct.getAdviceNum())));
    		
    		orderProductList.add(orderProduct);
    	}
    	
    	return ResponseResult.success(orderProductList);
    }
    
    
    
}