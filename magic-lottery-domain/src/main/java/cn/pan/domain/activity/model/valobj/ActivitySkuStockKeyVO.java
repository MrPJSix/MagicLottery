package cn.pan.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 活动sku库存 key 值对象
 * @date 2024/7/11 22:35
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuStockKeyVO {

    /* 商品sku */
    private Long sku;
    /* 活动ID */
    private Long activityId;

}
