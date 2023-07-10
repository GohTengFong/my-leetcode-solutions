class Solution {
    public int maxProfit(int[] prices) {
        int maxCount = 0;
        int cheap = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < cheap && i != prices.length - 1) {
                cheap = prices[i];
            }
            
            if (prices[i] - cheap > maxCount) {
                maxCount = prices[i] - cheap;
            }
        }

        return maxCount;
    }
}