class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flipHorizontally(matrix);
    }
    
    private void transpose(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
    
    private void flipHorizontally(int[][] matrix) {
        for(int r=0; r<matrix.length; r++){
            int l =0;
             int ri = matrix.length-1;
            while(l<ri){
                int temp = matrix[r][l];
                matrix[r][l] = matrix[r][ri];
                 matrix[r][ri] = temp;
                l++;
                ri--;
            }
            
            
        }
        
        
    }
}
