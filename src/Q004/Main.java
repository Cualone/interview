package Q004;
/*819.가장 흔한 단어*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = new String[]{"hit"};

        System.out.println(mostCommonWord(paragraph, banned));

    }

    public static String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(List.of(banned));

        Map<String, Integer> counts = new HashMap<>();

        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String w : words) {
            if (!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
