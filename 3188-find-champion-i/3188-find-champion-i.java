class Solution {
    public int findChampion(int[][] grid) {
        int answer = -1;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != j && grid[i][j] == 1) {
                    if (answer == -1) answer = i;
                    else if (answer != -1 && j == answer) answer = i; 
                }
            }
        }
        
        return answer;
    }
}

/*

  0 1
0 0 1
1 0 0

  0 1 2
0 0 0 1
1 1 0 1
2 0 0 0

*/