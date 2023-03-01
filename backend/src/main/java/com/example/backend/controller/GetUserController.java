package com.example.backend.controller;

import com.example.backend.pojo.User;
import com.example.backend.service.user.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetUserController {

    @Autowired
    private GetUserService getUserService;


    @GetMapping("/api/getuser/")
    public List<User> getUser() {
        return getUserService.getUser();
    }
}
