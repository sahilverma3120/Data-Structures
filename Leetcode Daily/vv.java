
class Solution {
    public int maximumWealth(int[][] accounts) {
       int n = accounts.length;
      int m = accounts[0].length;
        
        int maxWealth = Integer.MIN_VALUE;
        
        for(int i=0;  i<n; i++){
            int customerWealth = 0;
            for(int j=0; j<m; j++){
              customerWealth +=  accounts[i][j];
                if(customerWealth > maxWealth){
                 maxWealth = customerWealth;
                }
            }
            
          }
        return maxWealth;
    }
}
