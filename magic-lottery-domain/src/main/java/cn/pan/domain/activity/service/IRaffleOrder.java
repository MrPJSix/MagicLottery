package cn.pan.domain.activity.service;

import cn.pan.domain.activity.model.entity.ActivityOrderEntity;
import cn.pan.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * @author MrPJSix
 * @description 抽奖活动订单接口
 * @date 2024/7/8 23:22
 */
public interface IRaffleOrder {

    /**
     * 以sku创建抽奖活动订单，获得参与抽奖资格（可消耗的次数）
     *
     * @param activityShopCartEntity 活动sku实体，通过sku领取活动。
     * @return 活动参与记录实体
     */
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);

}
