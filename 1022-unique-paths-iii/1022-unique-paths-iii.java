class Solution {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] grid, boolean[][] visited, int row, int col, int walkable, int count) {
        int answer = 0;
        if (grid[row][col] == 2) {
            if (walkable == count) return 1;
            else return 0;
        }

        for (int[] dir : dirs) {
            int nextRow = dir[0];
            int nextCol = dir[1];

            if (row + nextRow < 0 || row + nextRow == grid.length) {
                continue;
            } else if (col + nextCol < 0 || col + nextCol == grid[0].length) {
                continue;
            } else if (grid[row + nextRow][col + nextCol] == -1) {
                continue;
            } else if (visited[row + nextRow][col + nextCol]) {
                continue;
            } else {
                visited[row + nextRow][col + nextCol] = true;
                answer += dfs(grid, visited, row + nextRow, col + nextCol, walkable, count + 1);
                visited[row + nextRow][col + nextCol] = false;
            }
        }

        return answer;
    }

    public int uniquePathsIII(int[][] grid) {
        int walkable = 0;
        int startRow = 0;
        int startCol = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != -1) {
                    walkable++;
                } 
                
                if (grid[row][col] == 1) {    
                    startRow = row;
                    startCol = col;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[startRow][startCol] = true;
        return dfs(grid, visited, startRow, startCol, walkable, 1);
    }
}