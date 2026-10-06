// Week 8 Practice - Problem 4: Examination Question Grader
// Demonstrates polymorphism: abstract Question with grade()
// MCQ/TF = full points on exact match; ESSAY = keyword-based partial credit

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
    public abstract String getType();
}

class McqQuestion extends Question {
    public McqQuestion(String qt, String ca, String sa, int pts) { super(qt, ca, sa, pts); }

    @Override
    public double grade() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }

    @Override
    public String getType() { return "MCQ"; }
}

class TfQuestion extends Question {
    public TfQuestion(String qt, String ca, String sa, int pts) { super(qt, ca, sa, pts); }

    @Override
    public double grade() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }

    @Override
    public String getType() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String qt, String ca, String sa, int pts) { super(qt, ca, sa, pts); }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        else if (matchCount == 1) return points * 0.50;
        else return 0;
    }

    @Override
    public String getType() { return "ESSAY"; }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            // Format: TYPE "QuestionText" "CorrectAnswer" "StudentAnswer" Points
            // Use simple quote-aware parsing
            String[] tokens = line.split("\"");
            // tokens[0] = "TYPE ", tokens[1] = QuestionText, tokens[2] = " ",
            // tokens[3] = CorrectAnswer, tokens[4] = " ", tokens[5] = StudentAnswer, tokens[6] = " Points"
            String type = tokens[0].trim();
            String questionText = tokens[1];
            String correctAnswer = tokens[3];
            String studentAnswer = tokens[5];
            int pts = Integer.parseInt(tokens[6].trim());

            switch (type) {
                case "MCQ":   questions.add(new McqQuestion(questionText, correctAnswer, studentAnswer, pts)); break;
                case "TF":    questions.add(new TfQuestion(questionText, correctAnswer, studentAnswer, pts)); break;
                case "ESSAY": questions.add(new EssayQuestion(questionText, correctAnswer, studentAnswer, pts)); break;
            }
        }

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}
