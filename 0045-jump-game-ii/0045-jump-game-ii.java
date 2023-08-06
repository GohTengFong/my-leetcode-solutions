class Solution {
    private int canReach(int numOfJumps, int[] dp, int start) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= numOfJumps; i++) {
            if (start + i >= dp.length) break;

            min = Math.min(min, dp[start + i]);
        }

        if (min == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return 1 + min;
        }
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        dp[dp.length - 1] = 0;

        for (int i = dp.length - 2; i >= 0; i--) {
            int numOfJumps = nums[i];

            dp[i] = canReach(numOfJumps, dp, i);
        }

        return dp[0];
    }
}