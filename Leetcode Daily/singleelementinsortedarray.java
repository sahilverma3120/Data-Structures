/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.*/
    class Solution {
    public int singleNonDuplicate(int[] nums) {
    
        int left = 0;
        int n = nums.length;
        int right = n-1;;
     
      while(left<right){
          int mid = (left + right)/2;
          
          if(mid%2==0){
              if(nums[mid]==nums[mid+1]){
                  left=mid+2;}
              else{
                  right=mid;
              }}
          if(mid%2==1){
              if(nums[mid]==nums[mid-1]){
                  left=mid+1;
              }
              else{
                  right=mid-1;
              }
          }}
        return nums[left];
           }
}
//Approach 2
class Solution {

public int singleNonDuplicate(int[] nums) {
     int res = 0;
     for(int i : nums)
         res = (res ^ i);
     return res;
}
}
