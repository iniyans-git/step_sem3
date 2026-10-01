import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        // Sample moves for demo:
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int totalRounds = playerMoves.length;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[][] roundTable = new String[totalRounds][4];

        for (int i = 0; i < totalRounds; i++) {
            String pMove = playerMoves[i];
            String cMove = moves[random.nextInt(moves.length)];
            String result = playRound(pMove, cMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else if (result.equals("Draw")) {
                draws++;
            }

            roundTable[i][0] = String.valueOf(i + 1);
            roundTable[i][1] = pMove;
            roundTable[i][2] = cMove;
            roundTable[i][3] = result;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");
        for (String[] row : roundTable) {
            System.out.printf("%-8s | %-12s | %-14s | %-15s%n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("---------------------------------------------------------------");

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                totalRounds, wins, losses, draws, winPercentage);
    }
}
