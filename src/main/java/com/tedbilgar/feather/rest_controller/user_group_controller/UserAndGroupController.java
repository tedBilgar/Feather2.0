package com.tedbilgar.feather.rest_controller.user_group_controller;

import com.tedbilgar.feather.service.userAndGroupService.UserAndGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/user_group")
public class UserAndGroupController {
    @Autowired
    private UserAndGroupService userAndGroupService;

    @GetMapping("/set")
    public void setRelation(@RequestParam("userId") Long userId,@RequestParam("groupId") Long groupId, @RequestParam("role") String role){
        userAndGroupService.setRelation(userId,groupId,role);
    }

    @RequestMapping("/test")
    public void test(){

    }
}
