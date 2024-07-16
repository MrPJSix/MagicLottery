package cn.pan.test.infrastructure;

import cn.pan.infrastructure.persistent.dao.IAwardDao;
import cn.pan.infrastructure.persistent.po.Award;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MrPJSix
 * @description 奖品持久化单元测试
 * @date 2024/5/21 22:23
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {
    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_queryAwardList() {
        List<Award> list = awardDao.queryAwardList();
        log.info("AwardDaoTest 测试结果：{}", JSON.toJSONString(list));
    }
}
