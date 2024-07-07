package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MrPJSix
 * @description 抽奖活动表Dao
 * @date 2024/7/7 13:21
 */
@Mapper
public interface IRaffleActivityDao {
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);
}
