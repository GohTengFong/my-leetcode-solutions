class Solution {
    private void recordState(ArrayList<List<String>> answer, int[][] board) {
        ArrayList<String> boardInList = new ArrayList<String>();
        
        for (int row = 0; row < board.length; row++) {
            StringBuilder state = new StringBuilder();
            
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 0) state.append('.');
                else state.append('Q');
            }

            boardInList.add(state.toString());
        }

        answer.add(boardInList);
    }

    private boolean canPut(int[][] board, int row, int col) {
        for (int i = row; i < board.length; i++) { // checking for all rows >= row
            if (board[i][col] == 1) return false;
        }
        for (int i = 0; i < row; i++) { // checking for all rows < row
            if (board[i][col] == 1) return false;
        }

        for (int i = col; i < board[0].length; i++) { // checking for all columns >= col
            if (board[row][i] == 1) return false;
        }
        for (int i = 0; i < col; i++) { // checking for all columns < col
            if (board[row][i] == 1) return false;
        }

        int tempRow = row + 1;
        int tempCol = col + 1;
        while (tempRow < board.length && tempRow >= 0 && tempCol < board[0].length && tempCol >= 0) { // checking diagonal, bottom right
            if (board[tempRow][tempCol] == 1) return false;
            tempRow++;
            tempCol++;
        }

        tempRow = row - 1;
        tempCol = col - 1;
        while (tempRow < board.length && tempRow >= 0 && tempCol < board[0].length && tempCol >= 0) { // checking diagonal, top left
            if (board[tempRow][tempCol] == 1) return false;
            tempRow--;
            tempCol--;
        }

        tempRow = row - 1;
        tempCol = col + 1;
        while (tempRow < board.length && tempRow >= 0 && tempCol < board[0].length && tempCol >= 0) { // checking diagonal, top right
            if (board[tempRow][tempCol] == 1) return false;
            tempRow--;
            tempCol++;
        }

        tempRow = row + 1;
        tempCol = col - 1;
        while (tempRow < board.length && tempRow >= 0 && tempCol < board[0].length && tempCol >= 0) { // checking diagonal, bottom left
            if (board[tempRow][tempCol] == 1) return false;
            tempRow++;
            tempCol--;
        }

        return true;
    }

    private void dfs(ArrayList<List<String>> answer, int remainingQ, int[][] board, int row) {
        if (remainingQ == 0) {
            recordState(answer, board);
        }

        if (row >= board.length) return;

        int[] nextRow = board[row];
        for (int col = 0; col < board[0].length; col++) {
            if (canPut(board, row, col)) {
                nextRow[col] = 1;
                dfs(answer, remainingQ - 1, board, row + 1);
                nextRow[col] = 0;
            }
        }

        return;
    }

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> answer = new ArrayList<List<String>>();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] firstRow = board[0];
            
            firstRow[i] = 1;

            dfs(answer, n - 1, board, 1);

            firstRow[i] = 0;
        }

        return answer;
    }
}