package com.example.backend.controller;

import com.example.backend.service.user.GetUseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetUserInfoController {

    @Autowired
    GetUseInfoService getUseInfoService;

    @PostMapping("/api/getinfo/")
    public Map<String, String> getInfo(@RequestParam Map<String, String> map) {

        String token = map.get("token");

        return getUseInfoService.getUserinfo(token);
    }
}
