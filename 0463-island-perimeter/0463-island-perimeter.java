class Solution {
    private int checkSides(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 1;
        } else if (grid[row][col] == 0) {
            return 1;
        }

        return 0;
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    perimeter += checkSides(grid, row + 1, col);
                    perimeter += checkSides(grid, row - 1, col);
                    perimeter += checkSides(grid, row, col + 1);
                    perimeter += checkSides(grid, row, col - 1);
                }
            }
        }

        return perimeter;
    }
}