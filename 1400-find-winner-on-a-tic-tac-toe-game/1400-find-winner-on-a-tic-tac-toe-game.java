class Solution {
    private int checkWinner(int[][] board) {
        int winner = -1;
        
        // check row
        for (int row = 0; row < board.length; row++) {
            int col1 = board[row][0];
            int col2 = board[row][1];
            int col3 = board[row][2];

            if (col1 == col2 && col2 == col3) winner = col1;
        }

        // check col
        for (int col = 0; col < board[0].length; col++) {
            int row1 = board[0][col];
            int row2 = board[1][col];
            int row3 = board[2][col];

            if (row1 == row2 && row2 == row3) winner = row1;
        }

        // check diagonals (right-left)
        int diag1 = board[0][2];
        int diag2 = board[1][1];
        int diag3 = board[2][0];
        if (diag1 == diag2 && diag2 == diag3) winner = diag1;

        // check diagonals (left-right)
        int diag4 = board[0][0];
        int diag5 = board[2][2];
        if (diag4 == diag2 && diag2 == diag5) winner = diag4;

        return winner;
    }

    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];

            if (i % 2 == 0) board[move[0]][move[1]] = 1;
            else board[move[0]][move[1]] = 2;

            int winner = checkWinner(board);

            if (winner == 1) return "A";
            else if (winner == 2) return "B";
        }

        return (moves.length == 9) ? "Draw" : "Pending";
    }
}