class Solution {
    // returns the max amount of money i can rob starting from house i
    private int helper(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (i == nums.length - 1 || i == nums.length - 2) {
            dp[i] = nums[i];
            return dp[i];
        }
        
        if (i == nums.length - 3) {
            dp[i] = nums[i] + nums[nums.length - 1]; 
            return dp[i];
        }

        dp[i] = nums[i] + Math.max(helper(i + 2, nums, dp), helper(i + 3, nums, dp));
        return dp[i];
    }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length]; //potential DP problem: state depends on the index
        Arrays.fill(dp, -1);

        if (nums.length == 1) return nums[0];

        return Math.max(helper(0, nums, dp), helper(1, nums, dp)); // i must either rob house 0 or 1
    }
}