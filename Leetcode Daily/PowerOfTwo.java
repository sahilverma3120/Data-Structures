/*

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
    if(n<=0)
        return false;
    return ((n&(n-1))==0);
}

}
