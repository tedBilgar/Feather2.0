package com.tedbilgar.feather.rest_controller.task_unit_package.desk_rest_package;

import com.tedbilgar.feather.domain.task_units.Desk;
import com.tedbilgar.feather.repository.task_unit_controller.desk_repo.DeskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/desk")
public class DeskRestController {
    @Autowired
    private DeskRepo deskRepo;

    @GetMapping
    public List<Desk> findAllDesks(){
        return deskRepo.findAll();
    }

    @GetMapping("{id}")
    public Desk findDeskById(@PathVariable Long id){
        return deskRepo.findDeskById(id);
    }

    @PostMapping
    public Desk addDesk(@RequestBody Desk desk){
        deskRepo.save(desk);
        return desk;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        deskRepo.deleteById(id);
    }
}
