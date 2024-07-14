package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.RaffleActivity;
import cn.pan.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MrPJSix
 * @description 抽奖活动表Dao
 * @date 2024/7/7 13:21
 */
@Mapper
public interface IRaffleActivityDao {

    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

    Long queryStrategyIdByActivityId(Long activityId);

    Long queryActivityIdByStrategyId(Long strategyId);

}
