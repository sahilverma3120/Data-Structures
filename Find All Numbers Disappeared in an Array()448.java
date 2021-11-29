/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
*/

class Solution {
   public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                idx = nums[i]*-1-1;
            }else{
                idx = nums[i]-1;
            }
            
            if(nums[idx]>0){
                nums[idx] -= nums[idx];
            }
            
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i);
            };
            
        }
        
        return list;
    }

}
