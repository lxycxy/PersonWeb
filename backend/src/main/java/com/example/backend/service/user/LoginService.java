package com.example.backend.service.user;


import java.util.Map;

public interface LoginService {

    Map<String, String> login(String username, String password);
}
