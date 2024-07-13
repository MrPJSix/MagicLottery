package cn.pan.domain.activity.model.aggregate;

import cn.pan.domain.activity.model.entity.ActivityAccountDayEntity;
import cn.pan.domain.activity.model.entity.ActivityAccountEntity;
import cn.pan.domain.activity.model.entity.ActivityAccountMonthEntity;
import cn.pan.domain.activity.model.entity.UserRaffleOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 参与活动订单聚合对象
 * @date 2024/7/13 10:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartakeOrderAggregate {

    /** 用户ID */
    private String userId;

    /** 活动ID */
    private Long activityId;

    /** 账户总额度 */
    private ActivityAccountEntity activityAccountEntity;

    /** 是否存在月账户 */
    private boolean isExistAccountMonth = true;

    /** 账户月额度 */
    private ActivityAccountMonthEntity activityAccountMonthEntity;

    /** 是否存在日账户 */
    private boolean isExistAccountDay = true;

    /** 账户日额度 */
    private ActivityAccountDayEntity activityAccountDayEntity;

    /** 抽奖单实体 */
    private UserRaffleOrderEntity userRaffleOrderEntity;

}
