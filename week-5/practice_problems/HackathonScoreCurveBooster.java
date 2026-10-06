import java.util.Arrays;

public class HackathonScoreCurveBooster {

    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) return;
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        int bonus = 5;
        System.out.println("Original Scores: " + Arrays.toString(scores));
        curveScores(scores, bonus);
        System.out.println("Curved Scores: " + Arrays.toString(scores));
    }
}
