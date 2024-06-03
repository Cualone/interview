package Q024;
/*232.스택을 이용한 큐 구현*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    static class MyQueue {
        Deque<Integer> input = new ArrayDeque<>();

        Deque<Integer> output = new ArrayDeque<>();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }


}
