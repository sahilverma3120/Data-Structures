Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

  class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            char nu = board[i][j];
         if(nu != '.')
             if(!seen.add(nu + "R" + i) || !seen.add(nu + "C" + j) || !seen.add(nu + "B" + i/3 +  "-" + j/3) ){
                 System.out.println(seen);
                 return false;}
            
        }
        }
        return true;
    }
}
