class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            if (matrix[startRow][endCol] == target) return true;
            else if (matrix[startRow][endCol] > target) endCol--;
            else if (matrix[startRow][endCol] < target) startRow++;
        }

        return false;
    }
}