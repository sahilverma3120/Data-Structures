/*Search Insert Position
Easy

Share
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.*/
class Solution {
 public int searchInsert(int[] nums, int target){
		int min = 0;
		int max = nums.length;
		return binaryS(min, max, nums, target);
	}

public int binaryS(int min, int max, int[] nums, int target){
    int count = min + (max-min)/2;
    if (max <= min){
        return max;
    }
    if (nums[count] == target){
        return count;
    }
    else if(nums[count] < target){
        return binaryS(count+1, max, nums, target);
    }
    else{
        return binaryS(min, count, nums, target);
    }
}
}
