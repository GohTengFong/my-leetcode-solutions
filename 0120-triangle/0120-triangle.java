class Solution {
    private void createDpTriangle(int[][] dp, List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int size = row.size();

            dp[i] = new int[size];
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int numOfRows = triangle.size();

        int[][] dp = new int[numOfRows][];
        createDpTriangle(dp, triangle);

        dp[0][0] = triangle.get(0).get(0); // base case
        for (int row = 1; row < numOfRows; row++) {
            List<Integer> currRow = triangle.get(row); // current row being worked on

            for (int index = 0; index < currRow.size(); index++) {
                if (index == 0) { // edge case, can only take from previous row and same index
                    dp[row][index] = currRow.get(index) + dp[row - 1][index];
                } else if (index == currRow.size() - 1) { // edge case, can only take from previous row and previous index
                    dp[row][index] = currRow.get(index) + dp[row - 1][index - 1];
                } else {
                    dp[row][index] = currRow.get(index) + Math.min(dp[row - 1][index], dp[row - 1][index - 1]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int[] lastDpRow = dp[dp.length - 1];
        for (int pathSum : lastDpRow) { // iterating through the last row to find minimum path sum
            answer = Math.min(answer, pathSum);
        }

        return answer;
    }
}

/*

Idea :
- maintain a dp triangle
- dp[row][index] represents the minimum path sum from dp[0][0] to dp[row][index]
- dp[row][index] = triangle.get(row).get(index) + Math.min(dp[row - 1][index], dp[row - 1][index - 1])
- edge cases when either edges of the current row, index == 0 and index == triangle.get(row).size() - 1

*/