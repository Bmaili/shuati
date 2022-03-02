package easy;

import java.util.ArrayList;

//121. 买卖股票的最佳时机
class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int money = 0;
        for(int i =0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            money = Math.max(money,prices[i]-min);
        }
        return money;
    }
}
