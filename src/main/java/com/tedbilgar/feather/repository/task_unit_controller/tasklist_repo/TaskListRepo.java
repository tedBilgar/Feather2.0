package com.tedbilgar.feather.repository.task_unit_controller.tasklist_repo;

import com.tedbilgar.feather.domain.task_units.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepo extends JpaRepository<TaskList,Long> {
    TaskList findTaskListById(Long id);
}
