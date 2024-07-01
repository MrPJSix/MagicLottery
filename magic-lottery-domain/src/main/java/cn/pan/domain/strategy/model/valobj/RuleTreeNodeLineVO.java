package cn.pan.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description
 * @date 2024/6/27 0:36
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleTreeNodeLineVO {

    /* 规则树ID */
    private String treeId;
    /* 规则Key 节点From */
    private String ruleNodeFrom;
    /* 规则Key 节点To */
    private String ruleNodeTo;
    /* 限定类型 —— 1: =; 2: >; 3: <; 4: >=; 5 <=; 6: enum[枚举范围] */
    private RuleLimitTypeVO ruleLimitType;
    /* 限定值（到下一个节点） */
    private RuleLogicCheckTypeVO ruleLimitValue;

}
