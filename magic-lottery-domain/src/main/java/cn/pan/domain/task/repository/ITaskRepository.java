package cn.pan.domain.task.repository;

import cn.pan.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @author MrPJSix
 * @description 任务服务仓储接口
 * @date 2024/7/14 14:57
 */
public interface ITaskRepository {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);

}
