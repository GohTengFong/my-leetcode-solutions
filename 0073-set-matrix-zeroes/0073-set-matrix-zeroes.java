class Solution {
    public void setZeroes(int[][] matrix) {
        // mark boundaries with 0
        boolean isCol = false;
        // mark first row and column
        int n = matrix[0].length, m = matrix.length;
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0) isCol=true;  // make sure we check it for each row only once.
            for(int j = 1;j<n;j++){
                if(matrix[i][j] == 0){ matrix[0][j] = 0; matrix[i][0]=0; }
            }
        }
        
        // from bottom to top
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--) // why till 1, it will be taken care by the isCol.
            {   
                if(matrix[0][j] == 0 ||  matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
            // make sure we change it after processing the row.
            if(isCol)
                matrix[i][0] = 0;
        }
    }
}