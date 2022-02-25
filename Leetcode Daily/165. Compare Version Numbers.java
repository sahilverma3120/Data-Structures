class Solution {
   public int compareVersion(String version1, String version2) {
       String[] v1 = version1.split("\\.");
       String[] v2 = version2.split("\\.");
       int m = v1.length;
       int n = v2.length;
       
       int i = 0, j = 0;
       while(i < m && j < n){
           int val1 = Integer.parseInt(v1[i++]);
           int val2 = Integer.parseInt(v2[j++]);
           if(val1 < val2) return -1;
           else if(val1 > val2) return 1;
       }
       
       if(i != m){
           while(i < m){
               int val1 = Integer.parseInt(v1[i++]);
               if(val1 > 0) return 1;   
           }
       }
       else if(j != n){
           while(j < n){
               int val2 = Integer.parseInt(v2[j++]);
               if(val2 > 0) return -1;
           }
       }
       
       return 0;
   }
}
