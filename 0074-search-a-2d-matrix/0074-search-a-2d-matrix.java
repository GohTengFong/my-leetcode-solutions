class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        // binary search to find out which row target lies in
        // by comparing target with the start and end elements of the middle row
        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow) / 2;
            int firstInMidRow = matrix[midRow][0];
            int lastInMidRow = matrix[midRow][endCol];

            if (target < firstInMidRow) endRow = midRow - 1; 
            else if (target > lastInMidRow) startRow = midRow + 1;
            else break; // target is found within the current row
        }

        if (!(startRow <= endRow)) return false; // target does not exists in any row

        // binary search within the row to find the target
        int start = 0;
        int end = endCol;
        int inRow = startRow + (endRow - startRow) / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[inRow][mid] == target) return true;
            else if (matrix[inRow][mid] < target) start = mid + 1;
            else if (matrix[inRow][mid] > target) end = mid - 1;
        }

        return false;
    }
}