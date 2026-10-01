import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) return;

        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        double[] scores = {40.0, 60.0, 50.0};
        int captain = 0;
        int viceCaptain = 1;

        System.out.println("Original scores: " + Arrays.toString(scores));
        applyMultipliers(scores, captain, viceCaptain);
        System.out.println("Boosted scores: " + Arrays.toString(scores));
    }
}
