package com.quiz.Roles;

import com.quiz.Question.QuestionBank;
import com.quiz.Question.Questions;

import java.util.Scanner;

public class Players {
    private final QuestionBank questionsBank;
    private final int playersCount;
    private final int[] scours;

    public Players(QuestionBank questionsBank, int playersCount) {
        this.playersCount = playersCount;
        this.questionsBank = questionsBank;
        scours = new int[playersCount];
    }

    public void playGame() {
        questionsBank.validateQuestionPresent();
        for (int i = 0; i < this.playersCount; i++) {
            System.out.printf("Turn of player %d" , i + 1);
            System.out.println(" ");
            startQuiz(i);
        }
        for(int i = 0; i < this.playersCount; i++){
            System.out.printf("Final Scour of player %d is %d", i + 1, scours[i]);
            System.out.println(" ");
        }
    }

    private void startQuiz(int player) {
        scours[player] = 0;
        Scanner scanner = new Scanner(System.in);
        for (Questions q : questionsBank.getQuestions()
        ) {
            for (int i = 0; i < 10; i++) {
                System.out.print("*");
            }
            System.out.println("  ");
            System.out.println("Q: " + q.getQuestion());
            for (int i = 0; i < 10; i++) {
                System.out.print("*");
            }
            System.out.println(" ");
            System.out.println("Option 1: " + q.getOption1());
            System.out.println("Option 2: " + q.getOption2());
            System.out.println("Option 3: " + q.getOption3());
            System.out.println("Option 4: " + q.getOption4());
            System.out.println("Would you like to Skip enter y/n");
            String skip = scanner.nextLine();
            if (skip.equalsIgnoreCase("n")) {
                System.out.println("Enter your answer");
                String answer = scanner.nextLine().trim();
                if (answer.equals(q.getAnswer())) {
                    scours[player] = scours[player] + 2;
                    System.out.println("Correct answer your current Score: " + scours[player]);
                } else {
                    scours[player] = scours[player] - 1;
                    System.out.println("Incorrect answer your current Score: " + scours[player]);
                }
            }
        }
    }
}
