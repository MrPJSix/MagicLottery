package cn.pan.domain.activity.service.rule;

import cn.pan.domain.activity.model.entity.ActivityCountEntity;
import cn.pan.domain.activity.model.entity.ActivityEntity;
import cn.pan.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/9 23:32
 */
public interface IActionChain extends IActionChainArmory {
    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);
}
