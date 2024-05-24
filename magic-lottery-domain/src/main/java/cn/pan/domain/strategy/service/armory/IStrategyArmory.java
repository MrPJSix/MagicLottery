package cn.pan.domain.strategy.service.armory;

/**
 * @author MrPJSix
 * @description 策略装配库，负责初始化策略计算
 * @date 2024/5/23 15:20
 */
public interface IStrategyArmory {
    boolean assembleLotteryStrategy(Long strategyId);
}
