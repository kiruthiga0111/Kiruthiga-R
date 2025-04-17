package com.userapp.service;

public class UserServiceImpl implements IUserService {

    @Override
    public void validateUsername(String username) {
        if ("kiruthiga".equals(username)) {
            System.out.println("welcome " + username);
        } else {
            System.out.println("Invalid username");
        }
    }

    @Override
    public void checkPassword(String password) {
        if (password.length() < 5) {
            System.out.println("Too short password");
        } else if (password.length() > 15) {
            System.out.println("Too long password");
        } else {
            System.out.println("Perfect password");
        }
    }
}
