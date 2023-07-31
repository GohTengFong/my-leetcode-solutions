class Solution {
    private void fillBaseCases(int[][] grid, int[][] dp) {
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        dp[lastRow][lastCol] = grid[lastRow][lastCol];

        for (int col = lastCol - 1; col >= 0; col--) {
            dp[lastRow][col] = dp[lastRow][col + 1] + grid[lastRow][col];
        }

        for (int row = lastRow - 1; row >= 0; row--) {
            dp[row][lastCol] = dp[row + 1][lastCol] + grid[row][lastCol];
        }
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        fillBaseCases(grid, dp);

        for (int row = rows - 2; row >= 0; row--) { // starting from last row - 1
            for (int col = cols - 2; col >= 0; col--) { // starting from last col - 1
                dp[row][col] = grid[row][col] + Math.min(dp[row + 1][col], dp[row][col + 1]);
            }
        }

        return dp[0][0];
    }
}