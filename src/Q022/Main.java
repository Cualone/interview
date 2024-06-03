package Q022;
/*739.일일 온도*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int[] temperatures = {23, 24, 25, 21, 19, 22, 26, 23};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

    }

    static int[] dailyTemperatures(int[] temperatures) {
        // 결과 저장
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 온도가 현재 스택의 top보다 높으면 pop 하여 그 index의 result 처리
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int last = stack.pop();
                result[last] = i - last;
            }
            stack.push(i);
        }
        return result;
    }
}
