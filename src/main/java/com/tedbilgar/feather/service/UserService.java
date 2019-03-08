package com.tedbilgar.feather.service;

import com.tedbilgar.feather.domain.units.Group;
import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.domain.units.UserGroup;
import com.tedbilgar.feather.repository.unit_package.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public void setRelUserGroup(User user, Group group, String role){
        User userFromDB = userRepo.findAllById(user.getId());
        userFromDB.getUserGroups().add(new UserGroup(user,group,role));
        userRepo.save(userFromDB);
    }
}
