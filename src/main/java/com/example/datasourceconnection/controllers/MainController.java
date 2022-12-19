package com.example.datasourceconnection.controllers;

import com.example.datasourceconnection.domain.User;
import com.example.datasourceconnection.service.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepoImpl userRepoImpl;

    @GetMapping()
    public String indexGet(){
        return "index";
    }

    @PostMapping()
    public String indexPost(@RequestParam String name, @RequestParam String sex, Map<String, Object> model){
        User user = new User();
        user.setUserName(name);
        user.setUserSex(sex);
        userRepoImpl.addUser(user);
        return "index";
    }

}
