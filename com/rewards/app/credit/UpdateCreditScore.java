package com.rewards.app.credit;

import com.rewards.app.user.Users;

public class UpdateCreditScore {
    private final Users user;

    UpdateCreditScore(Users user) {
        this.user = user;
    }

    public Users updateScore() {
        this.user.setCreditScoure(this.user.getCreditScoure() + 1000);
        return this.user;
    }

}
