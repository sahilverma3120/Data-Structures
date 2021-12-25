 Basic Calculator II
Medium

3597

485

Add to List

Share
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
class Solution {
    public int calculate(String s) {
        Stack<Integer> st  = new Stack<>();
        int n = s.length();
        char sign = '+';
        for(int i = 0; i < n ; i++)
        {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                int val = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    val = val*10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if(sign == '+'){
                    st.push(val);
                }
                else if(sign == '-'){
                    st.push(-val);
                }
                else if(sign == '*'){
                    int a = st.pop();
                    int ans = a*val;
                    st.push(ans);
                }
                else if(sign == '/'){
                    int a = st.pop();
                    int ans = a/val;
                    st.push(ans);
                }
            }else if(ch != ' '){
                sign = ch;
            }
        }
        int sum = 0;
        while(st.size() > 0) 
            sum += st.pop();
        return sum;
        
    }
}
