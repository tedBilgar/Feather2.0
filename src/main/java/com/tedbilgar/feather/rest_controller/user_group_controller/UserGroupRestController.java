package com.tedbilgar.feather.rest_controller.user_group_controller;

import com.tedbilgar.feather.domain.units.Group;
import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.domain.units.UserGroup;
import com.tedbilgar.feather.repository.group_repo.GroupRepo;
import com.tedbilgar.feather.repository.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("rest/user-group")
public class UserGroupRestController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupRepo groupRepo;

    @GetMapping
    public List<UserGroup> getAllUserGroups(){
        return userRepo.getAllUserGroups();
    }

    @GetMapping("user/{id}")
    public List<UserGroup> getByUserId(@PathVariable Long id){
        return userRepo.getByUserId(id);
    }
    @GetMapping("group/{id}")
    public List<UserGroup> getByGroupId(@PathVariable Long id){
        return userRepo.getByGroupId(id);
    }

    @GetMapping("set")
    public void setRelation(@RequestParam Long userId, @RequestParam Long groupId, @RequestParam String role){
        User user = userRepo.findAllById(userId);
        Group group = groupRepo.findGroupById(groupId);
        UserGroup userGroup = new UserGroup(user,group,"USER");

        user.getUserGroups().add(userGroup);

        groupRepo.save(group);
        userRepo.save(user);
    }

    @GetMapping("update")
    public void updateRelation(@RequestParam Long userId, @RequestParam Long groupId, @RequestParam String role){
        userRepo.updateRelation(userId,groupId,role);
    }
    @GetMapping("delete")
    public void deleteRelation(@RequestParam Long userId, @RequestParam Long groupId){
        userRepo.deleteRelation(userId, groupId);
    }
}
