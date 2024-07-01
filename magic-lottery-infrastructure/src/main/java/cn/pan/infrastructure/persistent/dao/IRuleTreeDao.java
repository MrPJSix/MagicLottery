package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/1 23:09
 */
@Mapper
public interface IRuleTreeDao {
    RuleTree queryRuleTreeByTreeId(String treeId);
}
