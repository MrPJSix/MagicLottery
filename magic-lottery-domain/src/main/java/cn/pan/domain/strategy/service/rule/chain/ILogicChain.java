package cn.pan.domain.strategy.service.rule.chain;

import cn.pan.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * @author MrPJSix
 * @description 抽奖策略规则责任链接口
 * @date 2024/6/24 23:03
 */
public interface ILogicChain extends ILogicChainArmory, Cloneable {
    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品对象
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);
}
