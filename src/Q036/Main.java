package Q036;
/*17.전화번호 문자 조합*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String digit = "24";

        System.out.println(letterCombinations(digit));

    }

    static void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        for (Character c : dic.get(digits.charAt(index))) {
            dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
        }
    }

    static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        Map<Character, List<Character>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));

        dfs(result, dic, digits, 0, new StringBuilder());
        return result;
    }
}

