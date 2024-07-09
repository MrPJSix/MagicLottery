package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MrPJSix
 * @description 商品sku Dao
 * @date 2024/7/7 13:20
 */
@Mapper
public interface IRaffleActivitySkuDao {

    RaffleActivitySku queryActivitySku(Long sku);

}
