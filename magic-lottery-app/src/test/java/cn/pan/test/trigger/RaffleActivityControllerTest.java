package cn.pan.test.trigger;

import cn.pan.trigger.api.IRaffleActivityService;
import cn.pan.trigger.api.dto.ActivityDrawRequestDTO;
import cn.pan.trigger.api.dto.ActivityDrawResponseDTO;
import cn.pan.trigger.api.dto.UserActivityAccountRequestDTO;
import cn.pan.trigger.api.dto.UserActivityAccountResponseDTO;
import cn.pan.types.model.Response;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/14 23:05
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityControllerTest {

    @Resource
    private IRaffleActivityService raffleActivityService;

    @Test
    public void test_armory() {
        Response<Boolean> response = raffleActivityService.armory(100301L);
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_draw() {
        for (int i = 0; i < 1; i++) {
            ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
            request.setActivityId(100301L);
            request.setUserId("MrPJSix");
            Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(request);

            log.info("请求参数：{}", JSON.toJSONString(request));
            log.info("测试结果：{}", JSON.toJSONString(response));
        }
    }

    @Test
    public void test_calendarSignRebate(){
        Response<Boolean> response = raffleActivityService.calendarSignRebate("MrPJSIx");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_isCalendarSignRebate() {
        Response<Boolean> response = raffleActivityService.isCalendarSignRebate("MrPJSix");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_queryUserActivityAccount() {
        UserActivityAccountRequestDTO request = new UserActivityAccountRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("MrPJSix");

        // 查询数据
        Response<UserActivityAccountResponseDTO> response = raffleActivityService.queryUserActivityAccount(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

}
