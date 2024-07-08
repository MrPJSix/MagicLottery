package cn.pan.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MrPJSix
 * @description 活动状态值对象
 * @date 2024/7/8 22:49
 */
@Getter
@AllArgsConstructor
public enum ActivityStateVO {

    create("create", "创建");

    private final String code;
    private final String desc;

}
