package cn.pan.domain.rebate.repository;

import cn.pan.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import cn.pan.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import cn.pan.domain.rebate.model.valobj.BehaviorTypeVO;
import cn.pan.domain.rebate.model.valobj.DailyBehaviorRebateVO;

import java.util.List;

/**
 * @author MrPJSix
 * @description 行为返利服务仓储接口
 * @date 2024/7/15 21:59
 */
public interface IBehaviorRebateRepository {

    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);

}
