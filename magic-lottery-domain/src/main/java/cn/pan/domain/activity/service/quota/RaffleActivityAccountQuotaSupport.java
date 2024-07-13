package cn.pan.domain.activity.service.quota;

import cn.pan.domain.activity.model.entity.ActivityCountEntity;
import cn.pan.domain.activity.model.entity.ActivityEntity;
import cn.pan.domain.activity.model.entity.ActivitySkuEntity;
import cn.pan.domain.activity.repository.IActivityRepository;
import cn.pan.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;

/**
 * @author MrPJSix
 * @description 抽奖活动支撑类
 * @date 2024/7/9 23:19
 */
public class RaffleActivityAccountQuotaSupport {
    protected DefaultActivityChainFactory defaultActivityChainFactory;

    protected IActivityRepository activityRepository;

    public RaffleActivityAccountQuotaSupport(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory) {
        this.activityRepository = activityRepository;
        this.defaultActivityChainFactory = defaultActivityChainFactory;
    }

    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }

}
