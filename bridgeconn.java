
class Solution {
    
    Queue<int[]> qu = new LinkedList<>();
    int n;//total rows
    int m;//total columns
    
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        
        if(grid.length==0){
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        
        boolean firstDfs = false;
        int ans = 1;
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    firstDfs = true;
                    markDfs(i, j, grid);
                    break;
                }
            }
            if(firstDfs){
                break;
            }
        }

        
        //now start calling from one island and keep enqueing in the queue with bfs to get shortest path or say connected with second island section.
        
        while(qu.size()>0){
            
            int sz = qu.size();
            
            while(sz>0){
                int[] rem = qu.remove();

                for(int di =0; di<4; di++){
                    int nrow = rem[0] + dirs[di][0];
                    int ncol = rem[1] + dirs[di][1];
                    
                    if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || grid[nrow][ncol]==-1){
                        continue;
                    }
                    if(grid[nrow][ncol]==1){
                       ans = rem[2];
                    return rem[2]; 
                    }
                    grid[nrow][ncol] = -1;
                    
                    qu.add(new int[]{nrow, ncol, rem[2] + 1});
                }
                sz--;
            }
        }
        return ans;
    }
    
    private void markDfs(int row, int col, int[][] grid){
        
        if(row < 0 || row >=n || col < 0 || col >= m || grid[row][col]!=1){
            return;
        }
        grid[row][col] = -1;
        
        qu.add(new int[]{row, col, 0});
        
        for(int di=0; di<4; di++){
            int nrow = row + dirs[di][0];
            int ncol = col + dirs[di][1];
            markDfs(nrow, ncol, grid);
        }     
    }
}
