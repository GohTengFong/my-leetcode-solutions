class Solution {
    private int countFresh(int[][] grid) {
        int count = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void findAllRotten(Queue frontier1, int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    frontier1.add(new int[] {row, col});
                }
            }
        }
    }

    private boolean addToFrontierTwo(Queue frontier2, int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return false;
        } else if (grid[row][col] == 1) {
            grid[row][col] = 2;
            frontier2.add(new int[] {row, col});
            return true;
        }

        return false;
    }

    public int orangesRotting(int[][] grid) {
        int freshCount = countFresh(grid);

        if (freshCount == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> frontier1 = new LinkedList<int[]>();
        findAllRotten(frontier1, grid);
        int time = 0;
        
        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            Queue<int[]> frontier2 = new LinkedList<int[]>();

            if (freshCount == 0) {
                return time;
            }

            for (int i = 0; i < size; i++) {
                int[] currPos = frontier1.poll();

                if (visited[currPos[0]][currPos[1]]) {
                    continue;
                } else {
                    visited[currPos[0]][currPos[1]] = true;
                    if (addToFrontierTwo(frontier2, grid, currPos[0] + 1, currPos[1])) freshCount--;
                    if (addToFrontierTwo(frontier2, grid, currPos[0] - 1, currPos[1])) freshCount--;
                    if (addToFrontierTwo(frontier2, grid, currPos[0], currPos[1] + 1)) freshCount--;
                    if (addToFrontierTwo(frontier2, grid, currPos[0], currPos[1] - 1)) freshCount--;
                }
            }

            time++;
            frontier1 = frontier2;
        }

        if (freshCount != 0) {
            return -1;
        } else {
            return time;
        }
    }
}