/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
*/
private int pos = 0;
    public String decodeString(String s) {
    	int n = s.length(), repeat = 0;
    	StringBuilder buf = new StringBuilder();
    	while (pos < n) {
    		char c = s.charAt(pos);
    		if (c >= 'a' && c <= 'z') {
    			buf.append(c);
    		} else if (c >= '0' && c <= '9') {
    			repeat = repeat * 10 + (c - '0');
    		} else if (c == '[') {
    			pos++;  // skip the char '['
    			String str = decodeString(s);  // pos is diff for each call
    			for (int i = 0; i < repeat; i++)
   					buf.append(str);
    			repeat = 0;  // reset the value for the next input
    		} else if (c == ']')
    			break;
    		pos++;
    	}
    	return buf.toString();
    }
