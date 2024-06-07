package Q033;
/*347.상위 k 빈도 엘리먼트*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequentPrimaryQueue(nums, k)));
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();

        for (int elem : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(elem);
            List<Integer> elems = buckets.getOrDefault(frequency, new ArrayList<>());
            elems.add(elem);
            buckets.put(frequency, elems);
        }

        int[] result = new int[k];
        int index = 0;

        for (int frequency = nums.length; frequency >= 0 && index < k; frequency--) {
            if (buckets.get(frequency) != null) {
                for (int elem : buckets.get(frequency)) {
                    result[index++] = elem;
                }
            }
        }

        return result;
    }

    static int[] topKFrequentPrimaryQueue(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int elem : frequencyMap.keySet()) {
            pq.add(new int[]{elem, frequencyMap.get(elem)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
