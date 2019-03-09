package com.tedbilgar.feather.repository.unit_package.user_repo.task;

import com.tedbilgar.feather.domain.task_units_relation.UserTask;

import java.util.List;

public interface TaskRepoCustom {
    List<UserTask> findAllUserTasks();
    UserTask findUserTask(Long userId,Long taskId);
    List<UserTask> findAllUsersByTask(Long taskId);
    List<UserTask> findAllTasksByUser(Long userId);

    void deleteRelationUserTask(Long userId,Long taskId);
}
