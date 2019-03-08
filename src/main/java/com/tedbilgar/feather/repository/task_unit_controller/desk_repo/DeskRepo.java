package com.tedbilgar.feather.repository.task_unit_controller.desk_repo;

import com.tedbilgar.feather.domain.task_units.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepo extends JpaRepository<Desk,Long> {
    Desk findDeskById(Long id);
}
