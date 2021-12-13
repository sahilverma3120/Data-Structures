class Solution {
    public int maxPower(String s) {
		// Taking max & count as 1 since minimum length of substring can be 1
        int max = 1, count = 1;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)!=s.charAt(i+1)) {
				// If the subsequent characters are not equal, then compare the count with max & update if required
                max = Math.max(max, count);
				// Reset count as 1, to check on remaining string
                count = 0;
                continue;
            }
            else
                count ++;
        }     
		// Incase of "abcc", max = 1, but count = 2, so we will be returning the max of them
        return Math.max(max, count);
    }
}
