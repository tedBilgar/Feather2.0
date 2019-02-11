package com.tedbilgar.feather.rest_controller.group_controller;

import com.tedbilgar.feather.domain.Group;
import com.tedbilgar.feather.repository.group_repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/group")
public class GroupRestController {
    @Autowired
    private GroupRepo groupRepo;

    @GetMapping
    public List<Group> findAll(){
        return groupRepo.findAll();
    }

    @GetMapping("{id}")
    public Group findById(@PathVariable Long id){
        return groupRepo.findGroupById(id);
    }

    @PostMapping
    public Group add(@RequestBody Group group){
        groupRepo.save(group);
        return group;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        groupRepo.deleteById(id);
    }
}
