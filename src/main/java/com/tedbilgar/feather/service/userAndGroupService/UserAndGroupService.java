package com.tedbilgar.feather.service.userAndGroupService;

import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.repository.group_repo.GroupRepo;
import com.tedbilgar.feather.repository.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndGroupService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GroupRepo groupRepo;

    public void setRelation(Long user_id,Long group_id){
        User user = userRepo.findAllById(user_id);
        user.getGroups().add(groupRepo.findGroupById(group_id));
        userRepo.save(user);
    }
}
