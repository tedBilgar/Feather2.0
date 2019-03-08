package com.tedbilgar.feather.repository.unit_package.group_repo;

import com.tedbilgar.feather.domain.units.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group,Long>{
    Group findGroupById(Long id);
}
