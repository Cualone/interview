package Q010;
/*561.배열파티션1*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        System.out.println(arrayPairSum(arr));
        System.out.println(arrayPairSum2(arr));

    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);

        for (int n : nums) {
            pair.add(n);
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }
        return sum;
    }

    public static int arrayPairSum2(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i=0;i<nums.length;i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
