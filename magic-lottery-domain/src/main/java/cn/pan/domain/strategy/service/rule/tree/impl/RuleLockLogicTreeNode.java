package cn.pan.domain.strategy.service.rule.tree.impl;

import cn.pan.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.pan.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.pan.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MrPJSix
 * @description
 * @date 2024/6/27 0:38
 */
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                .build();
    }
}
