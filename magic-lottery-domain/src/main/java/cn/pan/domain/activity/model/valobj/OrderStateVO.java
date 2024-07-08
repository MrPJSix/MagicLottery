package cn.pan.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MrPJSix
 * @description 订单状态枚举值对象
 * @date 2024/7/8 22:50
 */
@Getter
@AllArgsConstructor
public enum OrderStateVO {

    completed("completed", "完成");

    private final String code;
    private final String desc;

}
