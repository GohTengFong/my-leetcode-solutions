class Solution {
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean dfs(char[][] board, boolean[][] visited, StringBuilder currString, String word, int row, int col) {
        if (currString.toString().equals(word)) return true;
        else if (currString.length() >= word.length()) return false;

        visited[row][col] = true;

        for (int[] direction : directions) {
            int newX = direction[0] + row;
            int newY = direction[1] + col;

            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) continue;
            else if (visited[newX][newY]) continue;

            int letterForComparison = currString.length();

            if (board[newX][newY] == word.charAt(letterForComparison)) {
                currString.append(word.charAt(letterForComparison));

                if (!dfs(board, visited, currString, word, newX, newY)) {
                    currString.deleteCharAt(currString.length() - 1);
                } else {
                    return true;
                }
            }
        }

        visited[row][col] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);

        StringBuilder currString = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == firstLetter) {
                    currString.append(firstLetter);

                    if (dfs(board, visited, currString, word, row, col)) return true;

                    currString.deleteCharAt(currString.length() - 1);
                }
            }
        }

        return false;
    }
}