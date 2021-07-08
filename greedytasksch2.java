

class Solution {
public int leastInterval(char[] tasks, int n) {
    int[] count = new int[26];
    for(char c : tasks){
        count[c - 'A']++;
    }
    
    int maxFreq = 0;
    int groupSize = 0;
    
    for(int i : count){
        if(i > maxFreq){
            maxFreq = i;
            groupSize = 0;
        }
        if(maxFreq == i){
            groupSize++;
        }
    }
    
    return Math.max(tasks.length, (n + 1) * (maxFreq - 1) + groupSize);
    
    }
}
