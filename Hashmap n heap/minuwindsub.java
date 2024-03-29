class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
     /*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
     */
        HashMap<Character,Integer> map2 = new HashMap<>();
          for(int i=0; i<t.length(); i++){
              char ch = t.charAt(i);
              map2.put(ch,map2.getOrDefault(ch,0)+1);
          }
        int mct =0;
        int dmct = t.length();
        HashMap<Character,Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){
            //acquire
               boolean f1 = false;
         boolean f2 = false;
            while(i<s.length() - 1 && mct < dmct){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)){
                    mct++;
                }
                f1 = true;
            }
            
            //r&c
            while(j<i &&  mct == dmct){
               String pans = s.substring(j+1,i+1);
                if(ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }
                else{
                    map1.put(ch,map1.get(ch)- 1);
                }
                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){
                    mct--;
                }
                f2 = true;
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }
}


