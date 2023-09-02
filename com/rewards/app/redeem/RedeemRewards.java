package com.rewards.app.redeem;

import com.rewards.app.credit.ScoureHandler;
import com.rewards.app.user.UserHandler;
import com.rewards.app.user.Users;

import java.util.Scanner;
import java.util.UUID;

public class RedeemRewards implements Runnable {
    private final UserHandler userHandler;
    private final ScoureHandler scoureHandler;
    private Users user;

    public RedeemRewards(UserHandler userHandler, ScoureHandler scoureHandler) {
        this.userHandler = userHandler;
        this.scoureHandler = scoureHandler;
    }

    @Override
    public void run() {
        redeem();
    }

    private void redeem() {
        boolean runFlag = true;
        while (runFlag) {
            System.out.println("Please select one of following");
            System.out.println("press 1 To redeem the code");
            System.out.println("press 2 Exit");
            Scanner s = new Scanner(System.in);
            int selected = s.nextInt();
            if (1 == selected) {
                redeemCode();
            } else {
                scoureHandler.setFlag(false);
                runFlag = false;
            }
        }
    }

    private void redeemCode() {
        if (login()) {
            if (this.user.getCreditScoure() > 2000) {
                System.out.println("hi " + this.user.getUserName() + " you current scoure is " + this.user.getCreditScoure());
                System.out.println("press 1 to redeem code");
                Scanner scanner = new Scanner(System.in);
                int redeem = scanner.nextInt();
                if (redeem == 1) {
                    this.user.setCreditScoure(this.user.getCreditScoure() - 2000);
                    System.out.println("New scour is " + this.user.getCreditScoure());
                    System.out.println("Redeem code is " + UUID.randomUUID());
                }

            }
            else{
                System.out.println("low credit scoure"+this.user.getCreditScoure());
            }
        }
    }

    private boolean login() {
        int count = 5;
        Scanner scanner = new Scanner(System.in);
        while (count > 0) {
            System.out.println("enter user name");
            String userName = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            if (userHandler.getUserMap().containsKey(userName)) {
                if (userHandler.getUserMap().get(userName).getPassword().equals(password)) {
                    user = userHandler.getUserMap().get(userName);
                    return true;
                } else {
                    System.out.println("incorrect password");
                    count--;
                }
            } else {
                System.out.println("invalid user name please try again");
                count--;
            }
        }
        return false;
    }

}
