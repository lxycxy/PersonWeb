package com.example.backend.config.filter;


import com.auth0.jwt.interfaces.Claim;
import com.example.backend.utils.JWTUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class JWTFilter extends OncePerRequestFilter {

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

        String username;

        try {
            Map<String, Claim> claim = JWTUtils.verifyToken(token);
            username = claim.get("username").asString();
            request.setAttribute("username", username);

        } catch (Exception e) {
            throw new RuntimeException("token异常");
        }

        filterChain.doFilter(request, response);
    }


}
