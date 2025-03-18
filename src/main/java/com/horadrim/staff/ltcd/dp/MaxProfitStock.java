package com.horadrim.staff.ltcd.dp;

public class MaxProfitStock {
    public int solution(int [] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int solutionII(int[] prices) {
        int maxMoney = 0;//最大利润
        int slowIndex = 0;//慢指针
        int fastIndex = 1;//快指针
        int lastIndex = prices.length - 1;//最后索引
        while(fastIndex <= lastIndex){
            int money = prices[fastIndex] - prices[slowIndex];
            if(money > maxMoney){
                maxMoney = money;
            }
            if(money < 0){
                slowIndex = fastIndex;
            }
            ++fastIndex;
        }
        return maxMoney;
    }
}
