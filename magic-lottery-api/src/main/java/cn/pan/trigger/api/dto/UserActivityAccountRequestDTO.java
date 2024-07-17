package cn.pan.trigger.api.dto;

import lombok.Data;

/**
 * @author MrPJSix
 * @description 用户活动账户请求对象
 * @date 2024/7/17 22:38
 */
@Data
public class UserActivityAccountRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
