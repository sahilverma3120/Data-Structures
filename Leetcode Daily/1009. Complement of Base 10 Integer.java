
       class Solution {
    public int bitwiseComplement(int n) {
               
        int i = 1;
        
        while(i<n){
            i = i*2 + 1;
        }
        
        return i-n;
    }
}
    
