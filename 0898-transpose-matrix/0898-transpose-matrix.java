class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] answer = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < answer.length; row++) {
            for (int col = 0; col < answer[0].length; col++) {
                answer[row][col] = matrix[col][row];
            }
        }

        return answer;
    }
}