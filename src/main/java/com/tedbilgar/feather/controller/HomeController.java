package com.tedbilgar.feather.controller;


import com.tedbilgar.feather.domain.units.User;
import com.tedbilgar.feather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private UserService userService;

    private User getAuth(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) userService.loadUserByUsername(auth.getName());
        return user;
    }

    @GetMapping("")
    public ModelAndView getMain(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",getAuth());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/desks")
    public ModelAndView getDesks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",getAuth());
        modelAndView.setViewName("work/desk");
        return modelAndView;
    }
}
