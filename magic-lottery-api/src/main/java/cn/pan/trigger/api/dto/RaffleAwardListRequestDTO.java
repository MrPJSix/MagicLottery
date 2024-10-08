package cn.pan.trigger.api.dto;

import lombok.Data;

/**
 * @author MrPJSix
 * @description 抽奖奖品列表，请求对象
 * @date 2024/7/4 1:10
 */
@Data
public class RaffleAwardListRequestDTO {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;


}
