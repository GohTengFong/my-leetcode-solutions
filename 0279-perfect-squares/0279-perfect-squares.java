class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp[i] represents the least number of perfect square numbers that sum to i

        dp[0] = 0; // base case
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // initialise as base case where i = 1 + 1 + ... + 1
            
            // for all perfect squares before i, check if there is a possibility to decrease the value of dp[i]
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }
        
        return dp[n];
    }
}