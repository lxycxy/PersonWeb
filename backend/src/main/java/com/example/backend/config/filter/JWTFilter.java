package com.example.backend.config.filter;


import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 过滤器
 * 筛除不带token的请求
 * 筛除不合规范的登录
 */
@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    UserMapper userMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String token = null;

        if(! request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            token = request.getHeader("Authorization");
        }

        if(token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = null;

        try {
            Map<String, Claim> claim = JWTUtils.verifyToken(token);
            username = claim.get("username").asString();
            request.setAttribute("username", username);
        } catch (Exception e) {
//            response.getWriter().write("token异常");
//            filterChain.doFilter(request, response);
//            return;
            throw new RuntimeException("token异常");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        User user = userMapper.selectOne(queryWrapper.eq("username", username));

        if(user == null) {
            throw new RuntimeException("用户未注册");
        }


        filterChain.doFilter(request, response);
    }


}
