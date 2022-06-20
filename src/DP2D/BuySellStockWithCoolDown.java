package DP2D;

import java.util.HashMap;
import java.util.Map;

public class BuySellStockWithCoolDown {

    Map<String, Integer> mp;

    public int doDfs(int i, int buy, int[] prices){
        if(i >= prices.length){
            return 0;
        }
        String key = i+" "+buy;
        if (mp.containsKey(key)){
            return mp.get(key);
        }
        int coolDown = doDfs(i+1, buy, prices);
        if(buy == 1){
            int bought = doDfs(i+1, 0, prices) - prices[i];
            coolDown = Integer.max(bought, coolDown);
        }else{
            int sell = doDfs(i+2, 1, prices) + prices[i];
            coolDown = Integer.max(coolDown, sell);
        }
        mp.put(key, coolDown);
        return coolDown;
    }

    public int maxProfit(int[] prices) {
        mp = new HashMap<>(prices.length);
        return doDfs(0, 1, prices);
    }

    public static void main(String[] args){
        int [] p = {1};
        BuySellStockWithCoolDown b = new BuySellStockWithCoolDown();
        System.out.println(b.maxProfit(p));
    }

}
