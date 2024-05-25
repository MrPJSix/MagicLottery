package cn.pan.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 策略条件实体
 * @date 2024/5/25 15:47
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyConditionEntity {
    /* 用户ID */
    private String userId;
    /* 策略ID */
    private String strategyId;
}
