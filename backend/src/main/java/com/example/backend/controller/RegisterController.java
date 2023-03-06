package com.example.backend.controller;

import com.example.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController{
    @Autowired
    RegisterService registerService;


    @PostMapping("/api/register/")
    Map<String, String> register(@RequestParam Map<String, String> map) {
        Map<String, String> resp = new HashMap<>();

        String username, password, confirmedPassword;

        try {
            username = map.get("username");
            password = map.get("password");
            confirmedPassword = map.get("confirmedPassword");
        } catch (Exception e) {
            resp.put("info", "参数有误");
            return resp;
        }

        return registerService.register(username, password, confirmedPassword);
    }
}
