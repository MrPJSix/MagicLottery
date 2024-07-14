package cn.pan.trigger.api.dto;

import lombok.Data;

/**
 * @author MrPJSix
 * @description 活动抽奖请求对象
 * @date 2024/7/14 18:10
 */
@Data
public class ActivityDrawRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
