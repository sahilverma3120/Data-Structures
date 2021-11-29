class Solution {
    public int[] beautifulArray(int n) {            
        int[] res = new int[n];     //odd,even 
        if(n == 1) {
            res[0] = 1;
            return res;
        }
            int[] right =beautifulArray(n/2);
            int[] left = beautifulArray((n+1)/2);
            //Adding The Even nos.
            for(int i=left.length; i<n; i++) {
                res[i] = right[i-left.length] * 2; 
            }
            // Adding the  odd nos.
            for(int i=0; i<left.length; i++) {
                res[i] = left[i] * 2 - 1;     
            }
        return res;
}
}
