package com.chanhtin.controller;

import com.chanhtin.model.Comment;
import com.chanhtin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BaseService service;

    private Page<Comment> getComment(Pageable pageable){
        return service.findAll(pageable);
    }


    @GetMapping
    public ModelAndView showCreateForm(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("comments", getComment(pageable));
        return modelAndView;
    }

    @PostMapping
    public String addComment(@ModelAttribute("comments") Comment comment){
        service.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String likeComment(@PathVariable Long id ){
        Comment comment= service.findByID(id);
        comment.setLikes(comment.getLikes()+1);
        service.save(comment);
        return "redirect:/";
    }


}
