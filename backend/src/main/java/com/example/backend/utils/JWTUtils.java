package com.example.backend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt验证登录工具
 */

@Component
public class JWTUtils {

    public static final long JWT_TTL = 60 * 60 * 1000L * 24 * 7; // token过期时间为7天
    public static final String JWT_KEY = "SDFGjhdsfaltcdfHFdsHsjhfds121232131afasdfac";


    /**
     * 生成用户的token， 设置token的时间
     * @param
     * @return
     */
    public static String createToken(String username, String password) {
        Date expireDate = new Date(System.currentTimeMillis() + JWT_TTL);

        Map<String, Object> map = new HashMap<>();

        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(map)
                .withClaim("username", username)
                .withClaim("password", password)
                .withExpiresAt(expireDate) // 超时设置
                .withIssuedAt(new Date()) // 签发时间
                .sign(Algorithm.HMAC256(JWT_KEY)); // 加密

        return token;
    }


    /**
     * 校验并解析token
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWT_KEY)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            return null;
        }

        return jwt.getClaims();
    }
}
