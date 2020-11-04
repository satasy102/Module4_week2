package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("create-user")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("add");
            return modelAndView;
        } else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("add");
            return modelAndView;
        }
    }

    @GetMapping("admin-user")
    public ModelAndView listUsers(){
        Iterable<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }


}
