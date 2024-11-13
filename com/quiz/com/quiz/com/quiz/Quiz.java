package com.quiz;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start(Scanner scanner) {
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            
            // Display options
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            
            System.out.print("Your answer: ");
            int userChoice = scanner.nextInt();
            String userAnswer = options[userChoice - 1];
            
            // Check answer
            if (userAnswer.equals(question.getCorrectAnswer())) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong. The correct answer is: " + question.getCorrectAnswer() + "\n");
            }
        }
    }

    public int getScore() {
        return score;
    }
}
