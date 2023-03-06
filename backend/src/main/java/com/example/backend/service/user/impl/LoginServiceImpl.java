package com.example.backend.service.user.impl;

import com.example.backend.service.user.LoginService;
import com.example.backend.utils.JWTUtils;
import org.springframework.stereotype.Service;

/**
 * 根据用户名、密码使用 utils 创建 token
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String username, String password) {
        return JWTUtils.createToken(username, password);
    }
}
