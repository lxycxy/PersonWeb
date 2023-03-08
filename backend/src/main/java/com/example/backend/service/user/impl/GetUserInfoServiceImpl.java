package com.example.backend.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.user.GetUseInfoService;
import com.example.backend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GetUserInfoServiceImpl implements GetUseInfoService {

    @Autowired
    UserMapper userMapper;

    /**
     * 传入token 获取信息
     * @param token
     * @return
     */
    @Override
    public Map<String, String> getUserinfo(String token) {
        Map<String, String> resp = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        String username = JWTUtils.verifyToken(token).get("username").asString();
        User user = userMapper.selectOne(queryWrapper.eq("username", username));

        resp.put("id", user.getId().toString());
        resp.put("username", user.getUsername());
        resp.put("photo", user.getPhoto());

        return resp;
    }
}
