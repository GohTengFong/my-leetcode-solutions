class Solution {
    private boolean checkIfReachable(int[] nums, int start, int numOfJumps, boolean[] dp) {
        for (int i = 1; i <= numOfJumps; i++) {
            if (start + i >= nums.length) break;

            if (start + i == nums.length - 1) return true;
            else if (dp[start + i]) return true;
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        
        dp[dp.length - 1] = true;

        for (int i = dp.length - 2; i >= 0; i--) {
            int numOfJumps = nums[i];

            dp[i] = checkIfReachable(nums, i, numOfJumps, dp);
        }

        return dp[0];
    }
}