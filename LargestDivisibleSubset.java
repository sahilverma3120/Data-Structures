class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        for(int i=0;i<n; i++){
            for(int j=0; j<i; j++){
              if(nums[i]  % nums[j] == 0 ) {
                  dp[i] = Math.max(dp[i], 1 + dp[j]);
              }
            
            }
        }
        // For finding the end position (ax(dp[i]))
          int ind = 0;
           int m =0;
        for(int i=0; i<n; i++) {
            if(m < dp[i]){
                m = dp[i];
                ind = i;
            }
        }
         List<Integer> ans = new ArrayList();
        ans.add(nums[ind]);
        int last  = nums[ind];
        int left = m-1;
        ind--;
        for(int i = ind; i >=0; i--){
if(left == 0)
            break;
         if(dp[i] == left && last%nums[i] == 0){
        ans.add(nums[i]);
         last = nums[i];
             left--;
         }
        }
        return ans;
    }
}
