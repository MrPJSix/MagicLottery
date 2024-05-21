package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MrPJSix
 * @description 策略规则Dao
 * @date 2024/5/21 21:10
 */
@Mapper
public interface IStrategyRuleDao {
    List<StrategyRule> queryStrategyRuleList();
}
