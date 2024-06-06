package Q031;
/*771.보석과 돌*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        System.out.println(numJewelsInStones(J, S));
        System.out.println(numJewelsInStonesInHashSet(J, S));
    }

    static int numJewelsInStones(String J, String S) {
        int count = 0;
        Map<Character, Integer> freqs = new HashMap<>();

        for (char s : S.toCharArray()) {
            if (freqs.containsKey(s))
                freqs.put(s, freqs.get(s) + 1);
            else
                freqs.put(s, 1);
        }
        for (char j : J.toCharArray()) {
            if (freqs.containsKey(j))
                count += freqs.get(j);
        }
        return count;
    }

    static int numJewelsInStonesInHashSet(String J, String S) {
        int count = 0;
        Set<Character> freqs = new HashSet<>();

        for (char j : J.toCharArray())
            freqs.add(j);
        for (char s : S.toCharArray())
            if (freqs.contains(s)) count++;

        return count;
    }
}
