public class DuplicateTeamChecker {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length < 2) {
            return "No Duplicates Found";
        }

        // Plain nested loops, no Collections
        for (int i = 0; i < teamNames.length; i++) {
            if (teamNames[i] == null) continue;
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] list1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(list1));

        String[] list2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(list2));
    }
}
