/*
class Solution {
    public int findPairs(int[] nums, int k) {       
       Map<Integer, Integer> map = new HashMap<>();
        int pairsCount = 0;
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        
        for(Integer key: map.keySet()) {
            
            if(k == 0 && map.get(key) > 1)
                pairsCount++;
            else if(k > 0 && map.containsKey(key-k))
                pairsCount++;
        }
     
        return pairsCount;
    }
}
*/

class Solution {
    public int findPairs(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
        int pairsCount = 0;
        for(int i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for(Integer key : map.keySet()) {
            if(k == 0 &&  map.get(key) > 1)
                pairsCount++;
            else if(k > 0 && map.containsKey(key - k))
                pairsCount++;
        }
        return pairsCount++;
    }
}
