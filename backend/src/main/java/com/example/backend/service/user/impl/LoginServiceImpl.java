package com.example.backend.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.user.LoginService;
import com.example.backend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据用户名、密码使用 utils 创建 token
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;
    @Override
    public Map<String, String> login(String username, String password) {

        Map<String, String> resp = new HashMap<>();

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));

        if(user == null || ! JWTUtils.passwordEncoder(password).equals(user.getPassword())) {
            resp.put("info", "用户名错误或密码错误");
            return  resp;
        }

        resp.put("info", "success");
        resp.put("token", JWTUtils.createToken(username, password));

        return resp;
    }
}
