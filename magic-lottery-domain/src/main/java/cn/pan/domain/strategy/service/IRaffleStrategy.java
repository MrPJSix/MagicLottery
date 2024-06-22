package cn.pan.domain.strategy.service;

import cn.pan.domain.strategy.model.entity.RaffleAwardEntity;
import cn.pan.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @author MrPJSix
 * @description 抽奖策略接口
 * @date 2024/5/25 21:41
 */
public interface IRaffleStrategy {
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
