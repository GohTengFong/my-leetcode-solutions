class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        Queue<int[]> q = new LinkedList<int[]>();
        
            
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    q.add(new int[] {row, col});
                    visited[row][col] = true;
                }
            }
        }
        
        int step = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] currPos = q.poll();

                for (int[] dir : dirs) {
                    int x = currPos[0] + dir[0];
                    int y = currPos[1] + dir[1];

                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y]) {
                        visited[x][y] = true;
                        matrix[x][y] = step;
                        q.add(new int[] {x, y}); 
                    }
                }
            }

            step++;
        }
        
        return matrix;
    }
}