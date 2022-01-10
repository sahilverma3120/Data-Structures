class Solution {
  public String addBinary(String a, String b) {
         StringBuilder sb = new StringBuilder();
        int l1 = a.length() - 1, l2 = b.length() - 1, carry = 0;
        while(l1 >=0 || l2 >=0){
            int sum = carry;
            if(l1 >= 0)  sum += a.charAt(l1--) - '0';
            if(l2 >= 0)  sum += b.charAt(l2--) - '0';
            sb.append(sum % 2);           //do (sum % 10) for solving Q415
            carry = sum / 2;          //do   sum / 10  for solving Q415
        }
        if(carry !=0) sb.append(carry);
         return sb.reverse().toString();  
  }
}
