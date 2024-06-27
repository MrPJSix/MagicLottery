package cn.pan.domain.strategy.service.rule.tree.factory.engine;

import cn.pan.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author MrPJSix
 * @description
 * @date 2024/6/27 0:41
 */
public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);
}
