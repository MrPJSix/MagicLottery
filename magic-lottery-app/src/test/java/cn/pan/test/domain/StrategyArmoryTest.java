package cn.pan.test.domain;

import cn.pan.domain.strategy.service.armory.StrategyArmoryDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author MrPJSix
 * @description
 * @date 2024/5/23 17:53
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {
    @Autowired
    private StrategyArmoryDispatch strategyArmory;

    @Test
    public void test_strategyArmory() {
        strategyArmory.assembleLotteryStrategy(100002L);
    }

    @Test
    public void test_getRandomAward() {
        log.info("获取抽奖奖品ID:{}", strategyArmory.getRandomAwardId(100002L));
        log.info("获取抽奖奖品ID:{}", strategyArmory.getRandomAwardId(100002L));
        log.info("获取抽奖奖品ID:{}", strategyArmory.getRandomAwardId(100002L));
    }
}
