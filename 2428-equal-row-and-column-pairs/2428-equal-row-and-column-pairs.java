class Solution {
    public int equalPairs(int[][] grid) {
        List<int[]> rows = new ArrayList<int[]>();
        List<int[]> cols = new ArrayList<int[]>();

        for (int[] row : grid) rows.add(row);
        for (int col = 0; col < grid.length; col++) {
            int[] column = new int[grid.length];

            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }

            cols.add(column);
        }

        int answer = 0;
        for (int[] row : rows) {
            for (int[] col : cols) {
                if (Arrays.equals(row, col)) answer++;
            }
        }

        return answer;
    }
}