import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyLeagueAutoDraft {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            // Descending order of batting average / fantasy points
            return Double.compare(other.getBattingAverage(), this.getBattingAverage());
        }
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftable = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable.add(p);
            }
        }

        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
