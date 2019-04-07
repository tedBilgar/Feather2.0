package com.tedbilgar.feather.rest_controller.task_unit_package.tasklist_rest_package;

import com.tedbilgar.feather.domain.task_units.Desk;
import com.tedbilgar.feather.domain.task_units.TaskList;
import com.tedbilgar.feather.repository.task_unit_controller.desk_repo.DeskRepo;
import com.tedbilgar.feather.repository.task_unit_controller.tasklist_repo.TaskListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;

@RestController
@RequestMapping("rest/tasklist")
public class TaskListRestController {
    @Autowired
    private TaskListRepo taskListRepo;
    @Autowired
    private DeskRepo deskRepo;

    @GetMapping
    public List<TaskList> findAllTaskLists(){
        return taskListRepo.findAll();
    }

    @GetMapping("{id}")
    public TaskList findTaskListBiId(@PathVariable Long id){
        return taskListRepo.findTaskListById(id);
    }

    @GetMapping("desk/{deskid}")
    public List<TaskList> findTaskListByDeskId(@PathVariable Long deskid){
        Desk desk = deskRepo.findDeskById(deskid);
        return taskListRepo.findTaskListByDesk(desk);
    }

    @PostMapping
    public TaskList addTaskList(@RequestBody TaskList task){
        taskListRepo.save(task);
        return task;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        taskListRepo.deleteById(id);
    }
}
