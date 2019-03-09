package com.tedbilgar.feather.rest_controller.relation_package;

import com.tedbilgar.feather.domain.task_units.TaskList;
import com.tedbilgar.feather.domain.task_units_relation.UserTaskList;
import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.repository.task_unit_controller.tasklist_repo.TaskListRepo;
import com.tedbilgar.feather.repository.unit_package.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/user-tasklist")
public class UserTaskListController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TaskListRepo taskListRepo;

    @GetMapping
    public List<UserTaskList> findAll(){
        List<UserTaskList> userTaskLists = userRepo.findAllUserTaskLists();
        return userTaskLists;
    }

    @GetMapping("get")
    public UserTaskList findUserTaskList(@RequestParam Long userId,@RequestParam Long tasklistId){
        return userRepo.findUserTaskList(userId,tasklistId);
    }

    @GetMapping("tasklist/{id}")
    public List<UserTaskList> findAllUsersByTasklist(@PathVariable Long id){
        return userRepo.findAllUsersByTaskList(id);
    }

    @GetMapping("user/{id}")
    public List<UserTaskList> findAllTasklistsByUser(@PathVariable Long id){
        return userRepo.findAllTaskListsByUser(id);
    }

    @GetMapping("set")
    public void setRelation(@RequestParam Long userId,@RequestParam Long tasklistId, @RequestParam String role){
        UserTaskList userTaskListDB = findUserTaskList(userId,tasklistId);
        User user = userRepo.findAllById(userId);
        TaskList taskList = taskListRepo.findTaskListById(tasklistId);

        if(userTaskListDB !=null){
            userTaskListDB.setRole(role);
            user.getUserTaskLists().add(userTaskListDB);
            taskListRepo.save(taskList);
            userRepo.save(user);
            return;
        }

        UserTaskList userTaskList = new UserTaskList(user,taskList,role);

        user.getUserTaskLists().add(userTaskList);

        taskListRepo.save(taskList);
        userRepo.save(user);
    }

    @DeleteMapping("delete")
    public void deleteRelation(@RequestParam Long userId, @RequestParam Long tasklistId){
        userRepo.deleteRelationUserTaskList(userId,tasklistId);
    }
}
