
class Solution {
    public String convert(String s, int numRows) {
        String arr[] = new String[numRows];
        int count = 0;
        for(int i = 0; i < numRows; i++) {
            arr[i] = "";
        }
        while(true) {
            for(int i = 0; i < numRows; i++) {
               
            arr[i] += (s.charAt(count));
            count++;
            if(count == s.length()) {
                    break;
                }
            }
            if(count == s.length()) {
                break;
            }
            for(int i = numRows - 2; i > 0 ; i--) {
            arr[i] += (s.charAt(count));
            count++;
            if(count == s.length()) {
                break;
            }
            }
            if(count == s.length()) {
                break;
            }
        }
        String str = "";
        for(int i = 0; i < numRows; i++) {
            str += arr[i];
        }
        return str;
    }
}
