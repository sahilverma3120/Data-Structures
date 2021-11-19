// DP Solution with space optimization
// if up, up = down + 1, keep down
// if down, down = up + 1, keep up
// if tie, keep up and down
// Time complexity: O(N)
// Space complexity: O(1)
class Solution {
    public int wiggleMaxLength(int[] nums) {
        // Ask whether nums could be null
        final int N = nums.length;
        //Space complexity: O(1)
        if (N <= 1) 
            return N;
        int up = 1;
        int down = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
                // down + 1
            } 
            else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
