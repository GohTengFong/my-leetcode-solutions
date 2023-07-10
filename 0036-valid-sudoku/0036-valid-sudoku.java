class Solution {
    private boolean isValidRow(char[] row) {
        HashSet<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '.') {
                continue;
            } else if (set.contains(row[i])) {
                return false;
            } else {
                set.add(row[i]);
            }
        }

        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        HashSet<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '.') {
                continue;
            } else if (set.contains(board[i][col])) {
                return false;
            } else {
                set.add(board[i][col]);
            }
        }

        return true;
    }

    private boolean isValidSquare(char[][] board, int startCol) {
        HashSet<Character> set = new HashSet<Character>();

        for (int row = 0; row < board.length; row++) {
            if (row >= 3 && row % 3 == 0) {
                set.clear();
            }

            for (int col = startCol; col < startCol + 3; col++) {
                if (board[row][col] == '.') {
                    continue;
                } else if (set.contains(board[row][col])) {
                    return false;
                } else {
                    set.add(board[row][col]);
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board[i])) {
                return false;
            }
            
            if (!isValidCol(board, i)) {
                return false;
            }

            if (i % 3 == 0) {
                if (!isValidSquare(board, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}