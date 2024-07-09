package cn.pan.test.domain.activity;

import cn.pan.domain.activity.model.entity.ActivityOrderEntity;
import cn.pan.domain.activity.model.entity.SkuRechargeEntity;
import cn.pan.domain.activity.service.IRaffleOrder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/9 09:44
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleOrderTest {

    @Resource
    private IRaffleOrder raffleOrder;

    @Test
    public void test_createRaffleActivityOrder() {
        SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
        skuRechargeEntity.setUserId("panjinliu");
        skuRechargeEntity.setSku(9011L);
        String raffleActivityOrder = raffleOrder.createSkuRechargeOrder(skuRechargeEntity);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivityOrder));
    }

}
