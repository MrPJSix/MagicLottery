package cn.pan.domain.award.repository;

import cn.pan.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * @author MrPJSix
 * @description 奖品仓储服务
 * @date 2024/7/14 14:53
 */
public interface IAwardRepository {

    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

}
