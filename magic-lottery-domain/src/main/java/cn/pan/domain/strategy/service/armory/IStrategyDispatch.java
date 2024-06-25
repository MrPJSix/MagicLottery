package cn.pan.domain.strategy.service.armory;

/**
 * @author MrPJSix
 * @description 抽奖策略调度
 * @date 2024/5/24 14:37
 */
public interface IStrategyDispatch {
    Integer getRandomAwardId(Long strategyId);

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略权重ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param key = strategyId + _ + ruleWeightValue；
     * @return 抽奖结果
     */
    Integer getRandomAwardId(String key);
}
