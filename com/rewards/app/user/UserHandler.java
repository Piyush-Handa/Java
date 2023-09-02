package com.rewards.app.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserHandler {
    private final Map<String, Users> userMap = new HashMap<String, Users>();

    public Map<String, Users> getUserMap() {
        return userMap;
    }

    private void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name");
        String userName = scanner.nextLine();
        System.out.println("Enter user password");
        String password = scanner.nextLine();
        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(password);
        userMap.put(userName, user);
    }

    public void addClients() {
        System.out.println("enter number of users");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count > 0) {
            while (count > 0) {
                addUser();
                count--;
            }
        }
    }
}
