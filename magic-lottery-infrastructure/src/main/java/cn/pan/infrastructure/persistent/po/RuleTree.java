package cn.pan.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author MrPJSix
 * @description 规则树
 * @date 2024/6/27 0:37
 */
@Data
public class RuleTree {

    /* 自增ID */
    private Long id;
    /* 规则树ID */
    private String treeId;
    /* 规则树名称 */
    private String treeName;
    /* 规则树描述 */
    private String treeDesc;
    /* 规则根节点 */
    private String treeRootRuleKey;
    /* 创建时间 */
    private Date createTime;
    /* 更新时间 */
    private Date updateTime;

}
