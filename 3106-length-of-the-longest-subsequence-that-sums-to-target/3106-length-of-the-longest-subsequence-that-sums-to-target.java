class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        
        Collections.sort(nums);
        dp[0][0] = 0;
        if (nums.get(0) > target) return -1;
        dp[0][nums.get(0)] = 1;

        for (int row = 1; row < dp.length; row++) {
            int currNum = nums.get(row);
            
            for (int col = 0; col < dp[0].length; col++) {
                if (col == 0) {
                    dp[row][col] = 0;
                    continue;
                }
                
                if (currNum > col) {
                    dp[row][col] = dp[row - 1][col];
                } else if (currNum <= col) {
                    int opt1 = dp[row - 1][col];
                    int opt2 = dp[row - 1][col - currNum];
                    
                    if (opt1 == Integer.MIN_VALUE && opt2 == Integer.MIN_VALUE) continue;
                    else dp[row][col] = Math.max(opt1, 1 + opt2);
                }
            }
        }
        
        if (dp[nums.size() - 1][target] == Integer.MIN_VALUE) return -1;
        
        return dp[nums.size() - 1][target];
    }
}

/*

  0 1 2 3 4 5 6 7 8 9
1 0 1 x x x x x x x x
2 0 1 1 2 x x x x x x
3 0 1 1 2 2 2 x x x x
4 0 1 1 2 2 2 2 3 3 3
5 0 1 1 2 2 2 2 3 3 3

if (currNum > target) dp[i][j] = dp[i - 1][j]

if (currNum <= target) dp[i][j] = Math.max(dp[i - 1][j], 1 + dp[i - 1][target - currNum])

  0 1 2 3
1 0 1 x x
1 0 1 2 x
4 0 1 2 x
5 0 1 2 x 
5 0 1 2 x

*/