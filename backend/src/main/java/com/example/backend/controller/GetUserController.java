package com.example.backend.controller;

import com.example.backend.pojo.User;
import com.example.backend.service.user.GetUserService;
import com.example.backend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetUserController {

    @Autowired
    private GetUserService getUserService;


    @GetMapping("/api/getuser/")
    public List<User> getUser() {
        System.out.println("111");
        return getUserService.getUser();
    }

    @GetMapping("/api/login/")
    public String token(@RequestParam Map<String, String> map) {
        String username;
        String password;

        username = map.get("username");
        password = map.get("password");

        String jwt = JWTUtils.createToken(username, password);

        return jwt;
    }
}
