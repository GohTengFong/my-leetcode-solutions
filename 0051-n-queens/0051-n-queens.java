class Solution {
	// records a possible solution 
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
	
	// checks if it is possible to place a queen at board[row][col]
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
        if (remainingQ == 0) { // found a possible solution, add it to answer
            recordState(answer, board);
        }

        if (row >= board.length) return; // remainingQ != 0 and exceeding board, not a possible solution

        int[] nextRow = board[row];
        for (int col = 0; col < board[0].length; col++) { // iterate through all the columns of nextRow
            if (canPut(board, row, col)) { // found a possible space for a queen
                nextRow[col] = 1; // set the queen
                dfs(answer, remainingQ - 1, board, row + 1); // recursively explore nextRow + 1
                nextRow[col] = 0; // backtrack, unset the queen
            }
        }

        return;
    }

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> answer = new ArrayList<List<String>>();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) { // iterating through all the columns in the first row
            int[] firstRow = board[0];
            
            firstRow[i] = 1; // set the first queen

            dfs(answer, n - 1, board, 1);

            firstRow[i] = 0; // backtrack, unset the first queen
        }

        return answer;
    }
}

/*

Idea :
- brute force, for every space, try to put a queen
- starting from the first row, iterate through the columns
	- put a queen at board[row][col]
		- can be sure that it is possible since it is the first queen on the board
- recurse on nextRow
	- iterate through the columns of the next row
	- check if it is possible to put a queen at board[nextRow][col]
		- if it is possible, continue recursion on nextRow
		- if not possible, return
- must backtrack

*/