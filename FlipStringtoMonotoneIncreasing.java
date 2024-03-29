/*Our goal is to create a monotone increasing sequence. We can divide the sequence into two parts such that the left part would only contain 0s and the right part would only contain 1s. So, we need to find the optimal place to create the two partitions. For a given partition, our total cost would be sum of number of 1s on the left side and the number of 0s on the right side (they are the only digits we need to invert to create monotone increasing sequence). First, the number of 0s in the string S is counted. Now, starting from left to right, we are keeping the counts of 1s on left and 0s on right and updating the final answer if the current position is the best place to create a partition so far. There are two corner cases:
(1) When the partition is on the left corner (string of 1s): For this, answer is initialized with the total number of zeroes in the string.
(2) When the partition is on the right corner (string of 0s): For this, answer is updated at the end in case flipping all 1s to 0s results in optimal cost.
*/
class Solution {
    public int minFlipsMonoIncr(String S) {
        int zeroOnRight = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0'){
                zeroOnRight++;
            }
        }
        // partition at beginning
        int ans = zeroOnRight;
        int oneOnLeft = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0'){
                zeroOnRight--;
            }
            else{
                oneOnLeft++;
            }
            ans = Math.min(ans, oneOnLeft + zeroOnRight);
        }
        // partition at ending
        ans = Math.min(ans, oneOnLeft);
        return ans;
    }
}
