class Solution {
   public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k > 0) {
            int i = 0;
            //find the peak
            while (i < sb.length() - 1
                    && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            //delete the peak
            sb.deleteCharAt(i);
            k--;
        }
        //remove the leading 0s
        while (sb.toString().startsWith("0")) {
         sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
