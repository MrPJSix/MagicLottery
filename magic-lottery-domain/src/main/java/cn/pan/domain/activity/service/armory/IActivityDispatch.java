package cn.pan.domain.activity.service.armory;

import java.util.Date;

/**
 * @author MrPJSix
 * @description 活动调度【扣减库存】
 * @date 2024/7/11 22:45
 */
public interface IActivityDispatch {

    /**
     * @description 根据策略ID和奖品ID，扣减奖品缓存库存
     * @param sku 互动SKU
     * @param endDateTime 活动结束时间，根据结束时间设置加锁的key为结束时间
     * @return 扣减结果
     */
    boolean subtractionActivitySkuStock(Long sku, Date endDateTime);

}
