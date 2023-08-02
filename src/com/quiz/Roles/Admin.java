package com.quiz.Roles;

import com.quiz.Question.QuestionBank;
import com.quiz.Question.Questions;


public class Admin {
    private final QuestionBank questionBank;

    public Admin(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public void viewQuestions() {
        questionBank.ShowAllQuestions();
    }

    public void updateQuestionBank(int count, boolean includeExistingQuestions) {
   Questions[] backup = questionBank.getQuestions();
        if (includeExistingQuestions) {
            questionBank.setQuestionSetSize(questionBank.getTotalQuestions() + count);
            questionBank.addQuestions(includeExistingQuestions,backup);
        } else {
            questionBank.setQuestionSetSize(count);
            questionBank.addQuestions(includeExistingQuestions,null);
        }

    }


}
