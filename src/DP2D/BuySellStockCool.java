package DP2D;

public class BuySellStockCool {
    public int buySellStockCooldown(int[] prices, int i, int buying){
        if (i >= prices.length){
            return 0;
        }
        int cooldown = buySellStockCooldown(prices, i+1, buying);
        if (buying == 0){
            int buy = buySellStockCooldown(prices, i+1, 1) - prices[i];
            cooldown = Integer.max(cooldown, buy);
        }else{
            int sell = buySellStockCooldown(prices, i+2, 0) + prices[i];
            cooldown = Integer.max(cooldown, sell);
        }
        return cooldown;
    }
    public int maxProfit(int[] prices) {
        return buySellStockCooldown(prices, 0, 0);
    }

    public static void main(String[] args) {
        BuySellStockCool b = new BuySellStockCool();
        System.out.println(b.maxProfit(new int[]{1}));
    }
}
