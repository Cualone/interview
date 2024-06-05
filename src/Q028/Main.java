package Q028;
/*973.원점에서 가장 가까운 k개의 점*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Point {
        double distance;
        int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {6, -1}, {-2, 4}, {-2, 4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));

    }

    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

        for (int[] point : points) {
//            double distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
            // 순서만 동일하면 되기 때문에 sqrt를 할 필요는 없다.
            long distance = (long)point[0] * point[0] + (long)point[1] * point[1];
            pq.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll().point;
        }
        return results;
    }
}
