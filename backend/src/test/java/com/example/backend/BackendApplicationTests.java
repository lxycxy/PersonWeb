package com.example.backend;

import com.example.backend.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {

        System.out.println(JWTUtils.passwordEncoder("plxy"));
    }

}
