package com.tedbilgar.feather.repository.task_unit_controller.task_repo;

import com.tedbilgar.feather.domain.task_units.Task;
import com.tedbilgar.feather.domain.task_units.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Task findTaskById(Long id);
    List<Task> findTaskByTaskList(TaskList taskList);
}
