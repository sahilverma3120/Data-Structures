//https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
/*With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
word contains the first letter of puzzle.
For each letter in word, that letter is in puzzle.
For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage"; while invalid words are "beefed" (doesn't include "a") and "based" (includes "s" which isn't in the puzzle).
Return an array answer, where answer[i] is the number of words in the given word list words that are valid with respect to the puzzle puzzles[i].*/
//Test Cases

/*Example :

Input: 
words = ["aaaa","asas","able","ability","actt","actor","access"], 
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
Output: [1,1,3,2,4,0]
Explanation:
1 valid word for "aboveyz" : "aaaa" 
1 valid word for "abrodyz" : "aaaa"
3 valid words for "abslute" : "aaaa", "asas", "able"
2 valid words for "absoryz" : "aaaa", "asas"
4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
There're no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.*/
class Solution {
     private int toInt(String s) {
        int mask = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
       Map<Integer, Integer> map = new HashMap<>();
        for(String w: words) {
            int key = toInt(w);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(String p: puzzles) {
            int original = toInt(p), first = 1 << (p.charAt(0) - 'a'), count = 0;
            for(int subset = original; subset != 0; subset = (subset - 1) & original) {
                if((subset & first) != 0) {
                    count += map.getOrDefault(subset, 0);
                }
            }
            res.add(count);
        }
        return res;     `
        
    }
}
