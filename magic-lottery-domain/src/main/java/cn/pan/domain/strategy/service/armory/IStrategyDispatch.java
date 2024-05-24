package cn.pan.domain.strategy.service.armory;

/**
 * @author MrPJSix
 * @description 抽奖策略调度
 * @date 2024/5/24 14:37
 */
public interface IStrategyDispatch {
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);
}
