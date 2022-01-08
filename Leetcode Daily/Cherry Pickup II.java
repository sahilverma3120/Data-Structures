
        
        class Solution {
    public int cherryPickup(int[][] grid) {
        int ROW_NUM = grid.length, COL_NUM = grid[0].length;
        int D[] = {-1, 0, 1};
        int[][][] dp = new int[ROW_NUM][COL_NUM][COL_NUM];
        
        for (int i = 0; i < COL_NUM; i ++) // ulfill dp of the last row
            for (int j = i; j < COL_NUM; j ++)
                if (i == j)
                    dp[ROW_NUM - 1][i][j] = grid[ROW_NUM - 1][i];
                else
                    dp[ROW_NUM - 1][i][j] = grid[ROW_NUM - 1][i] + grid[ROW_NUM - 1][j];
        
        for (int k = ROW_NUM - 2; k >= 0; k --) { // from the second last row to the first row
            int row[] = grid[k];
            for (int i = 0; i <= COL_NUM; i ++)
              
                for (int j = i; j < COL_NUM; j ++) // we will get DP' in the picture
                    for (int di = 0; di < 3; di ++)
                        for (int dj = 0; dj < 3; dj ++) {
                            if (i + D[di] < 0 || i + D[di] >= COL_NUM || j + D[dj] < 0 || j + D[dj] >= COL_NUM) continue;
                            if (i != j) 
                            dp[k][i][j] = Math.max(dp[k][i][j], dp[k + 1][i + D[di]][j + D[dj]] + row[i] + row[j]);
                                //dp[k][i][j] = Math.max(dp[k][i][j], dp[k + 1][i + D[di]][j + D[dj]] + row[i]);
                            else
                            dp[k][i][j] = Math.max(dp[k][i][j], dp[k + 1][i + D[di]][j + D[dj]] + row[i]);
                                //
                        }
        }
        return dp[0][0][COL_NUM - 1];
    
        
    }
}
