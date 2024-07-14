package cn.pan.trigger.api;

import cn.pan.trigger.api.dto.ActivityDrawRequestDTO;
import cn.pan.trigger.api.dto.ActivityDrawResponseDTO;
import cn.pan.types.model.Response;

/**
 * @author MrPJSix
 * @description 抽奖活动服务
 * @date 2024/7/14 18:12
 */
public interface IRaffleActivityService {

    /**
     * 活动装配，数据预热缓存
     * @param activityId 活动ID
     * @return 装配结果
     */
    Response<Boolean> armory(Long activityId);

    /**
     * 活动抽奖接口
     * @param request 请求对象
     * @return 返回结果
     */
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);

}
