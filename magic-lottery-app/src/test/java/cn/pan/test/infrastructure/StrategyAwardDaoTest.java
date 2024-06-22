package cn.pan.test.infrastructure;

import cn.pan.infrastructure.persistent.dao.IStrategyAwardDao;
import cn.pan.infrastructure.persistent.po.StrategyAward;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author MrPJSix
 * @description
 * @date 2024/6/22 17:05
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyAwardDaoTest {
    @Autowired
    private IStrategyAwardDao strategyAwardDao;

    @Test
    public void test_queryStrategyAwardListByStrategyId() {
        List<StrategyAward> list = strategyAwardDao.queryStrategyAwardListByStrategyId(100001L);
        log.info("StrategyAwardDaoTest 测试结果：{}", list.toString());
    }
}
