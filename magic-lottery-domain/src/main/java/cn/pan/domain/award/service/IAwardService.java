package cn.pan.domain.award.service;

import cn.pan.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @author MrPJSix
 * @description 奖品服务接口
 * @date 2024/7/14 14:54
 */
public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

}
