//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 class Solution {
    
public int findMaxLength(int[] nums) {
    
int max = 0, count = 0;
Map<Integer, Integer> map = new HashMap<>();
map.put(0, -1);
for (int i = 0; i < nums.length; i++) {
if (nums[i] == 0) count -= 1;
else count += 1;

        if (map.containsKey(count)) {
            max = Math.max(max, i - map.get(count));
        } else 
            map.put(count, i+1);
    }
    
    return max;
}
}
