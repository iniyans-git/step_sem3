public class HackathonSeatingGridOptimizer {

    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < seatingScores.length; r++) {
            double avg = rowAverage(seatingScores[r]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            sb.append("Row ").append(r).append(": ").append(zone);
            if (r < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        System.out.println(classifyRows(seating, threshold));
    }
}
