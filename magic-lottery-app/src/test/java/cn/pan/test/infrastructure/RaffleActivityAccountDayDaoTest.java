package cn.pan.test.infrastructure;

import cn.pan.infrastructure.persistent.dao.IRaffleActivityAccountDayDao;
import cn.pan.infrastructure.persistent.po.RaffleActivityAccountDay;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author MrPJSix
 * @description 活动日账户DAO
 * @date 2024/7/14 23:02
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityAccountDayDaoTest {

    @Resource
    private IRaffleActivityAccountDayDao raffleActivityAccountDayDao;

    @Test
    public void test_queryRaffleActivityAccountDayPartakeCount() {
        RaffleActivityAccountDay raffleActivityAccountDay = new RaffleActivityAccountDay();
        raffleActivityAccountDay.setActivityId(100301L);
        raffleActivityAccountDay.setUserId("MyPJSix");
        raffleActivityAccountDay.setDay(raffleActivityAccountDay.currentDay());
        Integer dayPartakeCount = raffleActivityAccountDayDao.queryRaffleActivityAccountDayPartakeCount(raffleActivityAccountDay);
        log.info("测试结果:{}", dayPartakeCount);
    }

}
