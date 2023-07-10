class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int sizeMat = mat.length * mat[0].length;
        int sizeNew = r * c;

        if (sizeMat != sizeNew) {
            return mat;
        }

        int[][] answer = new int[r][c];
        int currRow = 0;
        int currCol = 0;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (currCol == c - 1) {
                    answer[currRow][currCol] = mat[row][col];
                    currRow++;
                    currCol = 0;
                } else {
                    answer[currRow][currCol] = mat[row][col];
                    currCol++;
                }
            }
        }

        return answer;
    }
}