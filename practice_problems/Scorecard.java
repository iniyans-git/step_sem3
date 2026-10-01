// Week 7 Practice - Problem 2: The Quiz Scorecard
// Demonstrates encapsulation: private results array, only score count exposed

public class Scorecard {
    private final boolean[] results;
    private final int totalQuestions;
    private int answeredCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answeredCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answeredCount < totalQuestions) {
            results[answeredCount] = isCorrect;
            answeredCount++;
        } else {
            System.out.println("All questions already answered. Recording ignored.");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answeredCount; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore()); // Expected: 3
    }
}
