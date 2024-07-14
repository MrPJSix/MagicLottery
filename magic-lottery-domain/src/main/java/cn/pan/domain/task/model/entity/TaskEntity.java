package cn.pan.domain.task.model.entity;

import lombok.Data;

/**
 * @author MrPJSix
 * @description 任务实体对象
 * @date 2024/7/14 14:56
 */
@Data
public class TaskEntity {

    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;


}
