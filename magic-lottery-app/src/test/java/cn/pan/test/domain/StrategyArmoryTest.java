package cn.pan.test.domain;

import cn.pan.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author MrPJSix
 * @description
 * @date 2024/5/23 17:53
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {
    @Resource
    private IStrategyArmory strategyArmory;

    @Test
    public void test_strategyArmory() {
        strategyArmory.assembleLotteryStrategy(100002L);
    }

    @Test
    public void test_getRandomAward() {
        log.info("获取抽奖奖品ID:{}", strategyArmory.getRandomAward(100002L));
        log.info("获取抽奖奖品ID:{}", strategyArmory.getRandomAward(100002L));
        log.info("获取抽奖奖品ID:{}", strategyArmory.getRandomAward(100002L));
    }
}
