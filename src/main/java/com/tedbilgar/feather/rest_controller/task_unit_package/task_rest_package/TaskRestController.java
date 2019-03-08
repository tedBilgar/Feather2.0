package com.tedbilgar.feather.rest_controller.task_unit_package.task_rest_package;

import com.tedbilgar.feather.domain.task_units.Task;
import com.tedbilgar.feather.repository.task_unit_controller.task_repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/task")
public class TaskRestController {
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping
    public List<Task> findAllTasks(){
        return taskRepo.findAll();
    }

    @GetMapping("{id}")
    public Task findTaskBiId(@PathVariable Long id){
        return taskRepo.findTaskById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        taskRepo.save(task);
        return task;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        taskRepo.deleteById(id);
    }
}
