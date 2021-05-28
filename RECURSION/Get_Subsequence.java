Maintain 2 pointers 'p1' and 'p2' denoting the left and right endpoints of a sub-array.
Initialize p1, p2 = 0.
Start moving p2 forward till a repetition is found. Maintain a set of elements in the window to figure out repetition.
As soon as a repetition is found, start contracting the window by moving the left pointer p1 forward. Reduce the elements from the sum and the set. Also store it in max if the sum is larger than the previously found maximum sum which is stored in max.
Keep doing this till p2 reaches the end of the array.
In the end, compare with 'max' as the running sum of the last window nay be more than the max found til now.
Return max as result
/*
Algorithm:
1. Maintain 2 pointers 'p1' and 'p2' denoting the left and right endpoints of a sub-array.
2. Initialize p1, p2 = 0.
3. Start moving p2 forward till a repetition is found. Maintain a set of elements in the window to figure out repetition.
4. As soon as a repetition is found, start contracting the window by moving the left pointer p1 forward. Reduce the elements from the sum and the set. Also store it in max if the sum is larger than the previously found maximum sum which is stored in max.
5. Keep doing this till p2 reaches the end of the array.
6. In the end, compare with 'max' as the running sum of the last window nay be more than the max found til now.
7. Return max as result
*/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        while(p2 < nums.length) {
            if(set.contains(nums[p2])) {
                max = Math.max(max, sum);
                while(nums[p1] != nums[p2]) {
                    set.remove(nums[p1]);
                    sum = sum - nums[p1];
                    p1++;
                }
                set.remove(nums[p1]);
                sum = sum - nums[p1];
                p1++;
            } 
            set.add(nums[p2]);
            sum = sum + nums[p2];
            p2++;
        }
        max = Math.max(max, sum);
        return max;
    }
}
