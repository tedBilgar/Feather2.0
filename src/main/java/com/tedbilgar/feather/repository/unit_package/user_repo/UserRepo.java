package com.tedbilgar.feather.repository.unit_package.user_repo;

import com.tedbilgar.feather.domain.units.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>, UserRepoCustom {
    User findByUsername(String username);
    User findAllById(Long id);
}
