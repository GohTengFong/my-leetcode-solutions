class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;
            
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    else if (maze[x][y] == '+') continue;
                    else if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;

                    maze[x][y] = '+';
                    queue.offer(new int[] {x, y});
                }
            }
        }

        return -1;
    }
}