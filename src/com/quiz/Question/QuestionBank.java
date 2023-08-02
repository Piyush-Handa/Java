package com.quiz.Question;


public class QuestionBank {
    private Questions[] questions = new Questions[5];

    public QuestionBank() {
        this.defaultQuestions();
    }

    /*
    set question bank size
     */
    public void setQuestionSetSize(int size) {
        this.questions = new Questions[size];
    }

    /*
    load default questions
     */
    public void defaultQuestions() {
        questions[0] = new Questions("size of int", "2", "6", "4", "8", "3");
        questions[1] = new Questions("size of double", "2", "6", "4", "8", "4");
        questions[2] = new Questions("size of char", "2", "6", "4", "8", "1");
        questions[3] = new Questions("size of long", "2", "6", "4", "8", "4");
        questions[4] = new Questions("size of boolean", "1", "2", "4", "8", "1");
    }

    public void ShowAllQuestions() {
        for (Questions q : questions) {
            System.out.println(q);
        }
    }

    /*
    Add questions to questionbank
    all keep track of default questions if admin wants to keep or not
     */
    public void addQuestions(boolean defaultQuestionsAdded) {
        int i;
        if (defaultQuestionsAdded) {
            i = 5;
        } else {
            i = 0;
        }
        for (; i < questions.length; i++) {
            Questions q = new Questions();
            String question = q.inputField("Enter the question");
            if (question.isBlank()) {
                System.out.println("Please try quiz again");
                continue;
            }
            q.setQuestion(question);
            String option1 = q.inputField("Enter option 1");
            q.setOption1(option1);
            String option2 = q.inputField("Enter option 2");
            q.setOption2(option2);
            String option3 = q.inputField("Enter option 3");
            q.setOption3(option3);
            String option4 = q.inputField("Enter option 4");
            q.setOption4(option4);
            String answer = q.inputField("Enter answer");
            q.setAnswer(answer);
            System.out.println(q);
            questions[i] = q;
        }


    }

    /*
    Fail safe to load question in app before playes start to play quiz
     */
    public void validateQuestionPresent() {
        boolean isPresent = true;
        for (Questions question : questions) {
            if (question == null) {
                isPresent = false;
                break;
            }
        }
        if (!isPresent) {
            setQuestionSetSize(5);
            defaultQuestions();
        }
    }

    public Questions[] getQuestions() {
        return questions;
    }

    public int getTotalQuestions() {
        return questions.length;
    }
}
