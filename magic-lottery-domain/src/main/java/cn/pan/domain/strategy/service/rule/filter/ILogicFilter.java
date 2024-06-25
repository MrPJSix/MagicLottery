package cn.pan.domain.strategy.service.rule.filter;

import cn.pan.domain.strategy.model.entity.RuleActionEntity;
import cn.pan.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @author MrPJSix
 * @description 抽奖规则过滤接口
 * @date 2024/5/25 21:58
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
