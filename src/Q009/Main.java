package Q009;
/*15.세 수의 합*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -5};

        System.out.println(threeSum(nums));
        System.out.println(threeSum2(nums));
    }

    // 브루트 포스
    // 타임아웃 발생
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;

                    if(nums[i] + nums[j] + nums[k] == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    // 투포인터
    public static List<List<Integer>> threeSum2(int[] nums) {
        int left, right, sum;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left += 1;
                    while (left < right && nums[right] == nums[right - 1]) right -= 1;
                    left += 1;
                    right -= 1;
                }
            }
        }
        return result;
    }
}