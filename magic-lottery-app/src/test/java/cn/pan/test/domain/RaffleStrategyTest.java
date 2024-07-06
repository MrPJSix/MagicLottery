package cn.pan.test.domain;

import cn.pan.domain.strategy.model.entity.RaffleAwardEntity;
import cn.pan.domain.strategy.model.entity.RaffleFactorEntity;
import cn.pan.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import cn.pan.domain.strategy.service.IRaffleStock;
import cn.pan.domain.strategy.service.IRaffleStrategy;
import cn.pan.domain.strategy.service.armory.IStrategyArmory;
import cn.pan.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import cn.pan.domain.strategy.service.rule.tree.impl.RuleLockLogicTreeNode;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * @author MrPJSix
 * @description
 * @date 2024/6/5 23:04
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;

    @Resource
    private RuleLockLogicTreeNode ruleLockLogicTreeNode;

    @Resource
    private IRaffleStock raffleStock;

    @Before
    public void setUp() {
        // 策略装配 100001、100002、100003
        //log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100001L));
        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100006L));

        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4900L);
        ReflectionTestUtils.setField(ruleLockLogicTreeNode, "userRaffleCount", 10L);
    }

    @Test
    public void test_performRaffle() throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                    .userId("panjl")
                    .strategyId(100006L)
                    .build();

            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

            log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
            log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
        }

        // 等待 UpdateAwardStockJob 消费队列
        new CountDownLatch(1).await();
    }

    @Test
    public void test_performRaffle_blacklist() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user003")  // 黑名单用户 user001,user002,user003
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }


    @Test
    public void test_raffle_center_rule_lock() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("panjl")
                .strategyId(100003L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

    @Test
    public void test_takeQueueValue() throws InterruptedException {
        StrategyAwardStockKeyVO strategyAwardStockKeyVO = raffleStock.takeQueueValue();
        log.info("测试结果：{}", JSON.toJSONString(strategyAwardStockKeyVO));
    }

}
