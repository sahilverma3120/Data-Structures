/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
*/

class Solution {
public int totalNQueens(int n) {
        int grid[][] = new int[n][n];
        N = n;
        solve(grid, 1);
        return ans;
    }
    
    int ans;
    int N;
    
    void solve(int[][] grid, int col) {
        if(col == N) {
            ans++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(isSafe(grid, i, col)) {
                grid[i][col] = 1;
                solve(grid, col + 1);
                grid[i][col] = 0;
            }
        }
    }
   
    boolean isSafe(int grid[][], int row, int col) {
        int i;
        int j;
        for(i = 0; i < row; i++) {
            if(grid[i][col] == 1) {
                return false;
            }
        }      
        for(j = 0; j < col; j++) {
            if(grid[row][j] == 1) {
                return false;
            }
        }
        i = row;
        j = col;
        while(i >= 0 && j >= 0) {
            if(grid[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        i = 0;
        j = col;
        
        while(i < N && j >=0) {
            if(grid[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
