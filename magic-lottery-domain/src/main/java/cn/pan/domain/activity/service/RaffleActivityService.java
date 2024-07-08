package cn.pan.domain.activity.service;

import cn.pan.domain.activity.repository.IActivityRepository;

/**
 * @author MrPJSix
 * @description 抽奖活动服务
 * @date 2024/7/8 23:30
 */
public class RaffleActivityService extends AbstractRaffleActivity {

    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }

}
