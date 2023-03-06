package com.example.backend.controller;

import com.example.backend.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 返回同于验证的token
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public String login(@RequestParam Map<String, String> map) {

        String username,password;

        username = map.get("username");
        password = map.get("password");

        return loginService.login(username, password);
    }
}
