class Solution {
    private int longestLIS(int[] nums, int i, int[] dp) { // returns the length of LIS starting at index i
        int currMax = 0;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i] && dp[j] > currMax) currMax = dp[j];
        }

        return currMax + 1;
    }

    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length]; // stores the length of LIS starting at index i
       Arrays.fill(dp, -1);
       dp[nums.length - 1] = 1;
       int maxLength = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = longestLIS(nums, i, dp);
            if (dp[i] > maxLength) maxLength = dp[i];
        }

        return maxLength;
    }
}