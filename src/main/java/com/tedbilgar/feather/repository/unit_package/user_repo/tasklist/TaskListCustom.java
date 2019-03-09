package com.tedbilgar.feather.repository.unit_package.user_repo.tasklist;

import com.tedbilgar.feather.domain.task_units_relation.UserTaskList;

import java.util.List;

public interface TaskListCustom {
    List<UserTaskList> findAllUserTaskLists();
    UserTaskList findUserTaskList(Long userId, Long tasklistId);
    List<UserTaskList> findAllUsersByTaskList(Long taskListId);
    List<UserTaskList> findAllTaskListsByUser(Long userId);

    void deleteRelationUserTaskList(Long userId,Long taskListId);
}
