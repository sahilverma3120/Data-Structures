//https://leetcode.com/problems/interval-list-intersections/discuss/1593579/JAVA-or-Two-Pointers-or-Most-Intutive
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 || secondList.length==0) return new int[0][0];
        int i = 0;
        int j = 0;
        int startMax = 0, endMin = 0;
        List<int[]> ans = new ArrayList<>();
        
        while(i<firstList.length && j<secondList.length){
            startMax = Math.max(firstList[i][0],secondList[j][0]);
            endMin = Math.min(firstList[i][1],secondList[j][1]);
            
			//you have end greater than start and you already know that this interval is sorrounded with startMin and endMax so this must be the intersection
			if(endMin>=startMax){           
                ans.add(new int[]{startMax,endMin});
            }
            
			//the interval with min end has been covered completely and have no chance to intersect with any other interval so move that list's pointer
            if(endMin == firstList[i][1]) i++;       
            if(endMin == secondList[j][1]) j++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
/*Runtime: 7 ms, faster than 14.52% of Java online submissions for Interval List Intersections.
Memory Usage: 52.1 MB, less than 22.79% of Java online submissions for Interval List Intersections.
Next challenges:*/
