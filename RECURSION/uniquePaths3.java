class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int count = 0; 
    
        int z = countEmptySquares(grid)+1;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                
                if(grid[i][j]==1){
                    count = upRec(i,j,grid,new boolean[grid.length][grid[0].length], z);
                }
                
            }
        }
        
        return count;
    }
    public int upRec(int cr, int cc, int grid[][], boolean visited[][], int zeros){
        
        if(grid[cr][cc]==2){
            if(zeros==0)
                return 1;
            else
                return 0;
        }
        
        if(grid[cr][cc]==-1){
            return 0;
        }
        
        int count = 0;
        
        if(!visited[cr][cc]){
            visited[cr][cc] = true;
            
            // Up move
            if(cr-1>=0)
                count += upRec(cr-1, cc, grid, visited, zeros-1);
    
            // Down move
            if(cr+1<=grid.length-1)
                count += upRec(cr+1, cc, grid, visited, zeros-1);
        
            // Left move
            if(cc-1>=0)
                count += upRec(cr, cc-1, grid, visited, zeros-1);
        
            // Right move
            if(cc+1<=grid[0].length-1)
                count += upRec(cr, cc+1, grid, visited, zeros-1);
        
            visited[cr][cc] = false;
        }
        
        return count;
    }
    
    public int countEmptySquares(int[][] grid){
        
        int count = 0;
        
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
        
                if(grid[r][c]==0){
                    count ++;
                }          
            }
        }
        
        return count;
    }
    
}
