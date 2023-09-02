package com.rewards.app.credit;

import com.rewards.app.user.UserHandler;
import com.rewards.app.user.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ScoureHandler implements Runnable {
    private final UserHandler userHandler;
    private boolean flag = true;

    public ScoureHandler(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            updateScore();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateScore() throws InterruptedException {
        while (flag) {
            Set<String> keySet = userHandler.getUserMap().keySet();
            List<String> keyList = new ArrayList<>(keySet);

            int size = keyList.size();
            int randIdx = new Random().nextInt(size);

            String randomKey = keyList.get(randIdx);
            Users randomUser = userHandler.getUserMap().get(randomKey);
            UpdateCreditScore cs = new UpdateCreditScore(randomUser);
            cs.updateScore();
            Thread.sleep(10000);
        }
    }

}
