package lab12;
import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Krisha", 950);
        scores.put("Diya", 870);
        scores.put("Ishita", 950);
        scores.put("Kashvi", 920);
        scores.put("KJ", 870);

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort((a, b) -> {
            int scoreCompare = b.getValue().compareTo(a.getValue());

            if (scoreCompare != 0)
                return scoreCompare;

            return a.getKey().compareTo(b.getKey());
        });

        int N = 3;

        System.out.println("Top " + N + " Players:");

        for (int i = 0; i < N && i < players.size(); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                    (i + 1) + ". " +
                    player.getKey() + " - " +
                    player.getValue()
            );
        }
    }
}


