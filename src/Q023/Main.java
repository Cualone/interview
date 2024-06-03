package Q023;
/*225.큐를 이용한 스택 구현*/

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }

    public static class MyStack {
        Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);
            for (int i = 1;i < queue.size();i++) {}
            queue.add(queue.remove());
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.size() == 0;
        }
    }
}
