package com.example.backend.service.user.impl;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.user.RegisterService;
import com.example.backend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    public static final String photo = "https://i.328888.xyz/2022/12/10/fKxnt.png";
    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> resp = new HashMap<>();

        if(username.isEmpty() || username.length() == 0|| username.length() > 16) {
            resp.put("info", "用户名不能为空或超过16位");
            return resp;
        }

        if(password.isEmpty() || password.length() == 0 || password.length() > 16 ) {
            resp.put("info", "密码不能为空或超过16位");
            return resp;
        }

        if(! confirmedPassword.equals(password)) {
            resp.put("info", "请确认第二次输入密码");
            return resp;
        }

        try {
            password = JWTUtils.passwordEncoder(password);
            userMapper.insert(new User(null, username, password, photo));
        } catch (Exception e) {
            resp.put("info", "用户名重复");

            return resp;
        }

        resp.put("info", "success");

        return resp;
    }
}
