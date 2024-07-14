package cn.pan.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 参与抽奖活动实体对象
 * @date 2024/7/12 22:26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartakeRaffleActivityEntity {

    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;

}
