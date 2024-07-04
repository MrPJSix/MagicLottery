package cn.pan.domain.strategy.service;

import cn.pan.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @author MrPJSix
 * @description 策略奖品接口
 * @date 2024/7/4 1:20
 */
public interface IRaffleAward {

    /**
     * 根据策略ID查询抽奖奖品列表配置
     *
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);

}
