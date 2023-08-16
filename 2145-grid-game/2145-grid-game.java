class Solution {
    public long gridGame(int[][] grid) {
        long answer = Long.MAX_VALUE;
        long lowerLeft = 0;
        long upperRight = 0;

        for (int cell : grid[0]) {
            upperRight += cell;
        }

        for (int i = 0; i < grid[0].length; ++i) {
            upperRight -= grid[0][i];
            answer = Math.min(answer, Math.max(upperRight, lowerLeft));
            lowerLeft += grid[1][i];
        }

        return answer;
    }
}