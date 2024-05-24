package cn.pan.domain.strategy.repository;

import cn.pan.domain.strategy.model.entity.StrategyAwardEntity;
import cn.pan.domain.strategy.model.entity.StrategyEntity;
import cn.pan.domain.strategy.model.entity.StrategyRuleEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author MrPJSix
 * @description
 * @date 2024/5/23 15:23
 */
public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTables(String key, Integer rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    Integer getRateRange(Long strategyId);

    Integer getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);
}
