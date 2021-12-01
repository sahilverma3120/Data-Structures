class Solution {
    public int rob(int[] nums) {
        int ifRobbed = 0;
        int ifNotRobbed = 0;
        for (int i : nums) {
            int temp = ifRobbed;
            ifRobbed = ifNotRobbed + i;
            ifNotRobbed = Math.max(temp, ifNotRobbed);
        }
        return Math.max(ifRobbed, ifNotRobbed);
    }
}
