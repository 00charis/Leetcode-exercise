//遍历一次，用当前值减去前面的最小值，同时更新当前的最小值。
//这个不是DP题
//参考solution
class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] - minValue > maxProfit){
                maxProfit = prices[i] - minValue;
            }
            
            minValue = Math.min(minValue, prices[i]);
        }
        
        return maxProfit;
    }
}