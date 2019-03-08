package com.tedbilgar.feather.repository.task_unit_controller.task_repo;

import com.tedbilgar.feather.domain.task_units.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Task findTaskById(Long id);
}
