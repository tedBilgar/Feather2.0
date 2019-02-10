package com.tedbilgar.feather.repository.user_repo;

import com.tedbilgar.feather.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findAllById(Long id);
}
