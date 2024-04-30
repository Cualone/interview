package Q005;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "ant", "cat"};
        System.out.println(groupAnagrams(arr));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }
}
