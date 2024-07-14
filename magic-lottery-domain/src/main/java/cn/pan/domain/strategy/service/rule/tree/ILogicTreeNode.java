package cn.pan.domain.strategy.service.rule.tree;

import cn.pan.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * @author MrPJSix
 * @description
 * @date 2024/6/27 0:38
 */
public interface ILogicTreeNode {
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue, Date endDateTime);
}
