class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false; // check if the total sum of nums can even be divided by 2

        int target = sum / 2; // the target sum for each half of the partition

        // dp[i][j] represents if it is possible to form target = j with any subset of items (0 - i)
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        for (int row = 0; row <= nums.length; row++) {
            dp[row][0] = true; // can always form target = 0 with i items (empty subset)
        }

        for (int col = 1; col <= target; col++) {
            dp[0][col] = false; // cannot form target = j with i = 0 items
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) { // incoming item may or may not be included
                    // dp[i - 1][j] represents excluding incoming item
                    // dp[i - 1][j - nums[i - 1]] represents including incoming item
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]);
                } else { // incoming item must be excluded
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}