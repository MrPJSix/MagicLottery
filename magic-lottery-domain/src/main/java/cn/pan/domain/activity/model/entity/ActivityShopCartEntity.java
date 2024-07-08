package cn.pan.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 活动购物车实体对象
 * @date 2024/7/8 22:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityShopCartEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 商品SKU - activity + activity count
     */
    private Long sku;

}
