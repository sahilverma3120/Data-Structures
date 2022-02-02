//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        
        if (lenP > lenS) {
            return res;
        }
        
        //left and right variables are used for making sliding window and when (right - left + 1 == lenP), 
		//then we will check if it is an anagram of String p.
        int left = 0;
        int right = 0;
        //Initially counter is set equal to length of String p, when it will become zero, then we will know 
		//that the substring of s is an anagram of String p.
        int counter = lenP;
        
        //Storing frequency of characters in String p in an array.
        int[] freq = new int[26];
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        while (right < lenS) {
            char rch = s.charAt(right);
            //If the character exists in freq array, then it can contribute in making anagram of String p, 
			//so decrease counter.
            if (freq[rch - 'a'] > 0) {
                counter--;
            }
            //Decrease the frequency of the character. 
            freq[rch - 'a']--;
            
            //Length of substring in String s (right - left + 1), is equal to length of String p, so it may 
			//be an anagram.
            if (right - left + 1 == lenP) {
                //If counter is zero, meaning it is an anagram, then add left in result arraylist, where 
				//left is the start index.
                if (counter == 0) {
                    res.add(left);
                }
                
                //Before moving left for checking further substrings, we will check if the frequency of the 
				//character it points is greater than or equal to zero (because, if the character's frequency 
				//was 2, then it would have become 1 or if it's frequency was 1, then it would have become 
				//zero). If it is, then increase the counter as we will have to find that character again in the 
				//new sliding window substring. 
                char lch = s.charAt(left);
                if (freq[lch - 'a'] >= 0) {
                    counter++;
                }
                //Increase it's frequency as we had decreased it before and now we are leaving it behind.
                freq[lch - 'a']++;
                
                //Now, move left.
                left++;
            }
            
            //Move right.
            right++;
        }
        
        return res;
    }
}
