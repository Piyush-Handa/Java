package com.rewards.app.application;

import com.rewards.app.credit.ScoureHandler;
import com.rewards.app.redeem.RedeemRewards;
import com.rewards.app.user.UserHandler;

public class RewardsApp {
    public static void main(String[] args) throws InterruptedException {

        UserHandler userHandler = new UserHandler();
        userHandler.addClients();
        if (!userHandler.getUserMap().isEmpty()) {
            ScoureHandler scoureHandler = new ScoureHandler(userHandler);
            RedeemRewards redeemRewards = new RedeemRewards(userHandler, scoureHandler);
            Thread scoure = new Thread(scoureHandler);
            Thread rewards = new Thread(redeemRewards);
            scoure.start();
            rewards.start();
            scoure.join();
            rewards.join();

        }
    }
}
