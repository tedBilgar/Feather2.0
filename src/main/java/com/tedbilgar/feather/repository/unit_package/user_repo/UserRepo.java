package com.tedbilgar.feather.repository.unit_package.user_repo;

import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.repository.unit_package.user_repo.desk.DeskRepoCustom;
import com.tedbilgar.feather.repository.unit_package.user_repo.group.UserRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>, UserRepoCustom, DeskRepoCustom {
    User findByUsername(String username);
    User findAllById(Long id);
}
