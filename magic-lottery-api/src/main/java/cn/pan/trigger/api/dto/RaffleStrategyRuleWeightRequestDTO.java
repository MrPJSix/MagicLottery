package cn.pan.trigger.api.dto;

import lombok.Data;

/**
 * @author MrPJSix
 * @description 抽奖策略规则，权重配置，查询N次抽奖可解锁奖品范围，请求对象
 * @date 2024/7/17 22:31
 */
@Data
public class RaffleStrategyRuleWeightRequestDTO {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}
