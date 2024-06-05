package Q029;
/*42626.더 맵게*/

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    static int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        int answer = 1;

        while(pq.size() > 1) {
            pq.add(pq.poll() + (pq.poll() * 2));

            if (pq.peek() >= k) return answer;

            answer++;
        }

        return -1;
    }
}
