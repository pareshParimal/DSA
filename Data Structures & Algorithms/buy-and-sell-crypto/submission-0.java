class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        int currMax = prices[len-1];
        int maxProfit = 0;

        for(int i= len-1;i>=0;i-- ){
            if(currMax-prices[i] > maxProfit){
                maxProfit = currMax- prices[i];
            }

            currMax= Math.max(currMax, prices[i]);
        }

        return maxProfit;
    }
}
