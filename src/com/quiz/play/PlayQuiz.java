package com.quiz.play;

import com.quiz.Question.QuestionBank;
import com.quiz.Roles.Admin;
import com.quiz.Roles.Players;

import java.util.Scanner;

public class PlayQuiz {
    private final QuestionBank questionBank;
    private final Scanner sc;

    public PlayQuiz() {

        this.questionBank = new QuestionBank();
        sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to quiz game");

        this.pickRole();
    }

    /*
    roles handling
     */
    private void pickRole() {
        int i = 0;
        do {
            System.out.println("Please choose one of the following");
            System.out.println("1: Admin");
            System.out.println("2: Players");
            System.out.println("0: Exit");
            i = sc.nextInt();
            switch (i) {
                case 1 -> adminActions();
                case 2 -> playerActions();
                default -> {
                    System.out.println("Thank you for trying the quiz app");
                    i = 0;
                }
            }

        } while (i != 0);
    }

    /*
    valide action of admin
     */
    private void adminActions() {
        int i = 0;
        Admin admin = new Admin(questionBank);
        do {
            System.out.println("Please select one of the following actions");
            System.out.println("1: Check out questions in question bank");
            System.out.println("2: Add more questions to the question bank");
            System.out.println("3: Create your own question bank");
            System.out.println("0: To go back to main menu");
            i = sc.nextInt();
            switch (i) {
                case 1 -> admin.viewQuestions();
                case 2 -> updateQuestionBank(admin, true);

                case 3 -> updateQuestionBank(admin, false);
                default -> i = 0;

            }
        } while (i != 0);
    }

    private void updateQuestionBank(Admin admin, boolean includeExistingQuestions) {
        System.out.println("please tell number of question you want to add");
        int count = sc.nextInt();
        admin.updateQuestionBank(count, includeExistingQuestions);
    }

    /*
    valid actions of player
     */
    private void playerActions() {
        int i = 0;

        do {
            System.out.println("Please select one of the following actions");
            System.out.println("1: Play game");
            System.out.println("2: Go to main menu");
            i = sc.nextInt();
            if (i == 1) {
                System.out.println("Please select number of players and count should be greater than 0");
                int players = 0;
                int tryCount = 0;
                while (players == 0) {
                    players = sc.nextInt();
                    if (tryCount > 5) {
                        i = 0;
                        break;
                    }
                    tryCount++;
                }
                Players player = new Players(questionBank, players);
                player.playGame();
            } else {
                i = 0;
            }
        }
        while (i != 0);
    }
}
