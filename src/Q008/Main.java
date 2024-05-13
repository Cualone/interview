package Q008;
/*42.빗물 트래핑*/
// 투포인터

public class Main {
    public static void main(String[] args) {
        int[] block = new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(block));
    }


    static int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                volume += leftMax - height[left];
                left += 1;
            } else {
                volume += rightMax - height[right];
                right -= 1;
            }
        }

        return volume;
    }
}
