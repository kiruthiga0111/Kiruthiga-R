package com.userapp.main;

import com.userapp.service.IUserService;
import com.userapp.service.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        userService.validateUsername("kiruthiga");
        userService.checkPassword("hello1234");
    }
}
