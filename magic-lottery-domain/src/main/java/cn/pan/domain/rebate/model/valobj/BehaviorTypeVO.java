package cn.pan.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MrPJSix
 * @description 行为类型枚举值对象
 * @date 2024/7/15 21:55
 */
@Getter
@AllArgsConstructor
public enum BehaviorTypeVO {

    SIGN("sign", "签到（日历）"),
    PAY("pay", "外部支付完成"),
    ;

    private final String code;
    private final String info;

}
