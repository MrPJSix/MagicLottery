package cn.pan.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 策略结果实体
 * @date 2024/5/25 15:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardEntity {
    /* 用户ID */
    private String userId;
    /* 奖品ID */
    private Integer awardId;
}
