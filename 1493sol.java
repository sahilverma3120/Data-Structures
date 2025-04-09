class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, zeroCount = 0, maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zeroCount++;
            
            while (zeroCount > 1) {
                if (nums[start] == 0) zeroCount--;
                start++;
            }
            // The length of the current window is (end - start)
            // Since we have to delete one element, we subtract 1.
            maxLength = Math.max(maxLength, end - start);
        }
        
        return maxLength;
    }
}
