package cn.pan.domain.activity.repository;

import cn.pan.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.pan.domain.activity.model.entity.ActivityCountEntity;
import cn.pan.domain.activity.model.entity.ActivityEntity;
import cn.pan.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author MrPJSix
 * @description 活动仓储接口
 * @date 2024/7/8 23:07
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void doSaveOrder(CreateOrderAggregate createOrderAggregate);
}
