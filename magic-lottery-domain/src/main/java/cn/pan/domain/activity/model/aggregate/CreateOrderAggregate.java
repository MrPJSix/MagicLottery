package cn.pan.domain.activity.model.aggregate;

import cn.pan.domain.activity.model.entity.ActivityAccountEntity;
import cn.pan.domain.activity.model.entity.ActivityOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 下单聚合对象
 * @date 2024/7/8 23:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderAggregate {

    /**
     * 活动账户实体
     */
    private ActivityAccountEntity activityAccountEntity;
    /**
     * 活动订单实体
     */
    private ActivityOrderEntity activityOrderEntity;

}
