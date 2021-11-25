class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sumsoFar = nums[0];
         int res1 =0;
    for(int i=0; i < nums.length; i++){
        if (sumsoFar > 0)
            sumsoFar = sumsoFar;
        else
        res1 += nums[i];
        res = Math.max(res,res1);
    }
        return res;
        
    }
}
