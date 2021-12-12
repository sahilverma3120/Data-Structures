class Solution {
    public boolean canPartition(int[] nums) {  
        int sum = 0;
	for(int i=0; i<nums.length; i++) {
		sum += nums[i];
	}
	if(sum % 2 != 0) {
		System.out.println(false);
	}
	
	else {
		sum = sum/2;
		// Applying target sum subset 
		boolean dp[][] = new boolean[nums.length+1][sum+1];
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if(i==0 && j==0) {
					dp[i][j] = true;
				}
				else if(i == 0) {
					dp[i][j] = false;
				}
				else if(j == 0) {
					dp[i][j] = true;
				}
				else {
					
					if(dp[i-1][j] == true) {
						dp[i][j] = true;
					}
					
					else {
						int val = nums[i-1];
						if(j >= val) {
							if(dp[i-1][j-val] == true) {
						    	dp[i][j] = true;
						    }
							
						}
						
					}
				    
					
				}
			}
		}
		
		if(dp[dp.length-1][dp[0].length-1] == true) {
			return true;
		}
		
	}
    
    return false;
}
    
}
