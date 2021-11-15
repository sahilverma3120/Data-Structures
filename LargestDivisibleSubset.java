class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
      // Filling The DP Table here
        Arrays.fill(dp,1);
        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
              if(nums[i]  % nums[j] == 0 ) {
                // Dp with The MAx Table 
                  dp[i] = Math.max(dp[i], dp[j] + 1);
              }
            
            }
        }
        // For finding the end position (ax(dp[i]))
          int ind = 0;
           int m =0;
        for(int i=0; i<n; i++) {
          // Declaring the mth position
            if(m < dp[i]){
                m = dp[i];
                ind = i;
            }
        }
      // The num List Array
         List<Integer> ans = new ArrayList();
        ans.add(nums[ind]);
        int last  = nums[ind];
        int left = m-1;
        ind--;
      // Finding The indices for the i >0
        for(int i = ind; i >=0; i--){
           if(left == 0)
            break;
          // The Break Condition 
         if(dp[i] == left && last%nums[i] == 0){
           // Adding The nums Position
        ans.add(nums[i]);
         last = nums[i];
             left--;
         }
        }
     //  Decrementing the Left Side now
        return ans;
    }
} 
