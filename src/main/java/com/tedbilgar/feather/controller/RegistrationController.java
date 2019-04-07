package com.tedbilgar.feather.controller;

import com.tedbilgar.feather.domain.roles.Role;
import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.repository.unit_package.user_repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registration(){
        return "enter/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){

       User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.put("message","User exists!");
            return "enter/registration";
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
