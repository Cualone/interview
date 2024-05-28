package Q012;
/*121.주식을 사고 팔기 가장 좋은 시점*/

public class Main {
    public static void main(String[] args) {
        int[] arr = {8, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    static int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
