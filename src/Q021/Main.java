package Q021;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "dbacdcbc";
        System.out.println(removeDuplicateLetters(input));
        System.out.println(removeDuplicateLettersInStack(input));
    }

    /*재귀*/
    static Set<Character> toSortedSet(String s) {
//        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                if (o1 == o2) return 0;
//                else if (o1>o2) return 1;
//                else return -1;
//            }
//        });

        // 람다
        Set<Character> set = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) return 0;
            else if (o1 > o2) return 1;
            else return -1;
        });

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    static String removeDuplicateLetters(String s) {
        for (char c : toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(c));
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }
        return "";
    }

    /*스택*/
    static String removeDuplicateLettersInStack(String s) {
        // 각 char의 수
        Map<Character, Integer> counter = new HashMap<>();
        // 스택에 char이 있는지 확인하는 용도
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        // String s에 대해서 각 char의 갯수 count
        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for (char c : s.toCharArray()) {
            // char count -1
            counter.put(c, counter.get(c) - 1);
            // 해당 char가 stack에 있다면 continue
            if (seen.get(c) != null && seen.get(c)) continue;

            // 스택에 char가 있고, stack의 top이 해당 char보다 뒤에 있으며 count가 남아있을 때
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                // 해당 char를 stack에서 pop 후 seen을 false로 변경
                seen.put(stack.pop(), false);
            }

            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}
