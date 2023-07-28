class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[dp.length - 1] = 0; // already at top
        dp[dp.length - 2] = cost[cost.length - 1]; // cost of taking last step

        for (int i = dp.length - 3; i >= 0; i--) {
            int oneStep = cost[i] + dp[i + 1];
            int twoStep = cost[i] + dp[i + 2];
            
            dp[i] = Math.min(oneStep, twoStep);
        }


        return Math.min(dp[0], dp[1]);
    }
}