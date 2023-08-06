class Solution {
    private int helper(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i == nums1.length || j == nums2.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int count = 0;

        if (nums1[i] == nums2[j]) {
            count = 1 + helper(i + 1, j + 1, nums1, nums2, dp);
        } else {
            count += Math.max(helper(i, j + 1, nums1, nums2, dp), helper(i + 1, j, nums1, nums2, dp));
        }

        dp[i][j] = count;

        return dp[i][j];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(0, 0, nums1, nums2, dp);
    }
}