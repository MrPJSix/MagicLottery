package cn.pan.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MrPJSix
 * @description 规则限定枚举值
 * @date 2024/6/27 0:36
 */
@Getter
@AllArgsConstructor
public enum RuleLimitTypeVO {

    EQUAL(1, "等于"),
    GT(2, "大于"),
    LT(3, "小于"),
    GE(4, "大于&等于"),
    LE(5, "小于&等于"),
    ENUM(6, "枚举")
    ;

    private final Integer code;
    private final String info;
}
