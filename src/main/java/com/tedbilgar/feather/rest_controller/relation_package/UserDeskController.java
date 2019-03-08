package com.tedbilgar.feather.rest_controller.relation_package;

import com.tedbilgar.feather.domain.task_units.Desk;
import com.tedbilgar.feather.domain.task_units_relation.UserDesk;
import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.repository.task_unit_controller.desk_repo.DeskRepo;
import com.tedbilgar.feather.repository.unit_package.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/user-desk")
public class UserDeskController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DeskRepo deskRepo;

    @GetMapping
    public List<UserDesk> findAll(){
        return userRepo.findAllUserDesks();
    }

    @GetMapping("desk/{id}")
    public List<UserDesk> findAllUsersByDesk(@PathVariable Long id){
        return userRepo.findAllUserByDesk(id);
    }

    @GetMapping("user/{id}")
    public List<UserDesk> findAllDesksByUser(@PathVariable Long id){
        return userRepo.findAllDeskByUser(id);
    }

    @GetMapping("set")
    public void setRelation(@RequestParam Long userId,@RequestParam Long deskId, @RequestParam String role){
        User user = userRepo.findAllById(userId);
        Desk desk = deskRepo.findDeskById(deskId);
        UserDesk userDesk = new UserDesk(user,desk,role);

        user.getUserDesks().add(userDesk);

        deskRepo.save(desk);
        userRepo.save(user);
    }

    @DeleteMapping("delete")
    public void deleteRelation(@RequestParam Long userId, @RequestParam Long deskId){
        userRepo.deleteRelationUserDesk(userId,deskId);
    }
}
