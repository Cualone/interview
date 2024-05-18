package Q011;
/*238.자신을 제외한 배열의 곱*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }
        return result;
    }
}
