package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MrPJSix
 * @description 抽奖策略Dao
 * @date 2024/5/21 21:08
 */
@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();
}
