/*

Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

*/


class Solution {
    public static void reverse(int nums[], int i, int j){
        int li = i, ri = j;
        while( li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;
            li++;
            ri--;
            }
    }
    // Diving into the number by the kth integer 
    // Function Helper
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k +=  nums.length;
        }
        reverse(nums,0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length -1);
        reverse(nums,0,nums.length-1);
    }
}
