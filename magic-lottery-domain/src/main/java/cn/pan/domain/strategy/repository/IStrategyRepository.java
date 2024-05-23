package cn.pan.domain.strategy.repository;

import cn.pan.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author MrPJSix
 * @description
 * @date 2024/5/23 15:23
 */
public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTables(Long strategyId, Integer rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    Integer getRateRange(Long strategyId);

    Integer getStrategyAwardAssemble(Long strategyId, Integer rateKey);
}
