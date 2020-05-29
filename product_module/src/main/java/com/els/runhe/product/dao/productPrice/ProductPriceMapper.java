package com.els.runhe.product.dao.productPrice;

import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPriceMapper {
    int countByExample(ProductPriceExample example);

    int deleteByExample(ProductPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductPrice record);

    int insertSelective(ProductPrice record);

    List<ProductPrice> selectByExample(ProductPriceExample example);

    ProductPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);

    int updateByExample(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);

    int updateByPrimaryKeySelective(ProductPrice record);

    int updateByPrimaryKey(ProductPrice record);

    List<ProductPrice> selectByExampleByPage(ProductPriceExample example);
}