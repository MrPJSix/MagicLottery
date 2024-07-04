package cn.pan.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MrPJSix
 * @description 抽奖奖品实体
 * @date 2024/5/25 21:46
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {

    /* 奖品ID */
    private Integer awardId;
    /* 奖品配置信息 */
    private String awardConfig;
    /* 奖品顺序号 */
    private Integer sort;

}
