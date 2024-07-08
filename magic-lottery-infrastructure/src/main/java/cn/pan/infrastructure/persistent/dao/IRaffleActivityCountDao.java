package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MrPJSix
 * @description 抽奖活动次数配置表Dao
 * @date 2024/7/7 13:18
 */
@Mapper
public interface IRaffleActivityCountDao {

    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);

}
