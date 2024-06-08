package Q034;
/*42576.완주하지 못한 선수*/

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] input = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(input, completion));

    }

    static String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();

        for (String p : participant) {
            m.put(p, m.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            int left = m.get(c);
            if (left == 1) {
                m.remove(c);
            } else {
                m.put(c, left - 1);
            }
        }
        return m.entrySet().iterator().next().getKey();
    }
}
