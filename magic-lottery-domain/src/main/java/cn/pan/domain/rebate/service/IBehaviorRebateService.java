package cn.pan.domain.rebate.service;

import cn.pan.domain.rebate.model.entity.BehaviorEntity;

import java.util.List;

/**
 * @author MrPJSix
 * @description 行为返利服务接口
 * @date 2024/7/15 22:04
 */
public interface IBehaviorRebateService {

    /**
     * 创建行为动作的入账订单
     *
     * @param behaviorEntity 行为实体对象
     * @return 订单ID
     */
    List<String> createOrder(BehaviorEntity behaviorEntity);

}
