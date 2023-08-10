class Solution {
    private int[] checkNeighbours(int[][] board, int row, int col) {
        int[] neighbours = new int[2];
        
        if (row - 1 >= 0) {
            if (col + 1 < board[0].length) neighbours[board[row - 1][col + 1]] += 1;
            if (col - 1 >= 0) neighbours[board[row - 1][col - 1]] += 1;

            neighbours[board[row - 1][col]] += 1;
        }

        if (row + 1 < board.length) {
            if (col + 1 < board[0].length) neighbours[board[row + 1][col + 1]] += 1;
            if (col - 1 >= 0) neighbours[board[row + 1][col - 1]] += 1;

            neighbours[board[row + 1][col]] += 1;
        }

        if (col - 1 >= 0) neighbours[board[row][col - 1]] += 1;

        if (col + 1 < board[0].length) neighbours[board[row][col + 1]] += 1;

        return neighbours;
    }

    private void updateTemp(int[][] board, int[][] temp, int row, int col, int value) {
        int[] neighbours = checkNeighbours(board, row, col);

        if (value == 0 && neighbours[1] == 3) {
            temp[row][col] = 1;
        } else if (value == 1) {
            if (neighbours[1] < 2) temp[row][col] = 0;
            else if (neighbours[1] == 2 || neighbours[1] == 3) temp[row][col] = 1;
            else if (neighbours[1] > 3) temp[row][col] = 0;
        }
    }

    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 0) updateTemp(board, temp, row, col, 0);
                else if (board[row][col] == 1) updateTemp(board, temp, row, col, 1);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = temp[row][col];
            }
        }
    }
}