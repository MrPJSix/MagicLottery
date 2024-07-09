package cn.pan.domain.activity.service.rule.impl;

import cn.pan.domain.activity.model.entity.ActivityCountEntity;
import cn.pan.domain.activity.model.entity.ActivityEntity;
import cn.pan.domain.activity.model.entity.ActivitySkuEntity;
import cn.pan.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/9 23:38
 */
@Slf4j
@Component("activity_sku_stock_action")
public class ActivitySkuStockActionChain extends AbstractActionChain {

    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-商品库存处理【校验&扣减】开始。");

        return true;
    }

}
