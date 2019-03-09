package com.tedbilgar.feather.rest_controller.relation_package;

import com.tedbilgar.feather.domain.task_units.Task;
import com.tedbilgar.feather.domain.task_units_relation.UserTask;
import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.repository.task_unit_controller.task_repo.TaskRepo;
import com.tedbilgar.feather.repository.unit_package.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/user-task")
public class UserTaskController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping
    public List<UserTask> findAll(){
        return userRepo.findAllUserTasks();
    }

    @GetMapping("get")
    public UserTask findUserTask(@RequestParam Long userId,@RequestParam Long taskId){
        return userRepo.findUserTask(userId,taskId);
    }

    @GetMapping("task/{id}")
    public List<UserTask> findAllUsersByTask(@PathVariable Long id){
        return userRepo.findAllUsersByTask(id);
    }

    @GetMapping("user/{id}")
    public List<UserTask> findAllTasksByUser(@PathVariable Long id){
        return userRepo.findAllTasksByUser(id);
    }

    @GetMapping("set")
    public void setRelation(@RequestParam Long userId,@RequestParam Long taskId, @RequestParam String role){
        UserTask userTaskDB = findUserTask(userId,taskId);
        User user = userRepo.findAllById(userId);
        Task task = taskRepo.findTaskById(taskId);

        if(userTaskDB !=null){
            userTaskDB.setRole(role);
            user.getUserTasks().add(userTaskDB);
            taskRepo.save(task);
            userRepo.save(user);
            return;
        }

        UserTask userTask = new UserTask(user,task,role);

        user.getUserTasks().add(userTask);

        taskRepo.save(task);
        userRepo.save(user);
    }

    @DeleteMapping("delete")
    public void deleteRelation(@RequestParam Long userId, @RequestParam Long taskId){
        userRepo.deleteRelationUserTask(userId,taskId);
    }
}
