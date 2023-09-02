package com.rewards.app.login;

import com.rewards.app.user.Users;

import java.util.Map;

public class Login {
    private final Map<String, Users> userMap;

    Login(Map<String, Users> usersMap) {
        this.userMap = usersMap;
    }

    public boolean validate(String userName, String password) {
        if (userMap.containsKey(userName)) {
            if (userMap.get(userName).getPassword().equals(password)) {
                return true;
            } else {
                System.out.println("Wrong password");
                return false;
            }
        }
        return false;
    }
}
