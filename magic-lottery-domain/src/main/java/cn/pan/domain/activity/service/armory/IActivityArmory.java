package cn.pan.domain.activity.service.armory;

/**
 * @author MrPJSix
 * @description 活动装配预热
 * @date 2024/7/11 22:44
 */
public interface IActivityArmory {

    boolean assembleActivitySkuByActivityId(Long activityId);

    boolean assembleActivitySku(Long sku);

}
