package sliding_window;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++){
            maxDiff = Integer.max(maxDiff, prices[i] - min);
            min = Integer.min(min, prices[i]);
        }
        if (maxDiff < 0)return 0;
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] m = {7,6,4,3,1};
        BestTimeBuySellStock b = new BestTimeBuySellStock();
        System.out.println(b.maxProfit(m));
    }
}
