package com.quiz.Roles;

import com.quiz.Question.QuestionBank;


public class Admin {
    private final QuestionBank questionBank;

    public Admin(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public void viewQuestions() {
        questionBank.ShowAllQuestions();
    }

    public void updateQuestionBank(int count, boolean includeExistingQuestions) {
        if (includeExistingQuestions) {
            questionBank.setQuestionSetSize(5 + count);
        } else {
            questionBank.setQuestionSetSize(count);
        }
        questionBank.addQuestions(includeExistingQuestions);
    }


}
