package Q007;
/*1.두 수의 합*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 6, 11, 15};
        int target = 8;
        System.out.println(Arrays.toString(twoSum_BF(nums, target)));
        System.out.println(Arrays.toString(twoSum_MP(nums, target)));
        System.out.println(Arrays.toString(twoSum_MP_Comb(nums, target)));
    }

    // 브루트 포스
    public static int[] twoSum_BF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // target에서 뺀 수가 있는지 map에 있는지 확인
    public static int[] twoSum_MP(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // (숫자, 인덱스)
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // target-nums[i]가 있는지, 그 키가 자기 자신인지
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }
        return null;
    }

    // for 문 통합
    public static int[] twoSum_MP_Comb(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }

            numsMap.put(nums[i], i);
        }
        return null;
    }
}
