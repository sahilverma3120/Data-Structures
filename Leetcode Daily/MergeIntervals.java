/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution {
   public int[][] merge(int[][] intervals) {
       
   	// sort our intervals 
     Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
  
       ArrayList<int[]> ans  =  new ArrayList<>();
   	// intial range 
       int start  =  intervals[0][0];
       int end =  intervals[0][1]; 
       
       int  i =1;
       while(i<intervals.length){
           int s = intervals[i][0];
           int e = intervals[i][1];
           // next interval start is smaller than prev end and array is sorted
           // so these two internal can merge
           if( s<=end  ) { 
               // so merge both intervals 
               end =  Math.max(end,e);
           }
           else{ // if merge not possible , then insert prev interval into list
               ans.add(new int[]{start,end});
               start = s;
               end =  e;                
           }
          i++;
       }
       
       ans.add(new int[] {start,end});
   	
   	  int arr[][] =  new int[ans.size()][];
           for(int i=0;i<ans.size();i++) {
           	int a[] =  new int[2];
           	for(int j=0;j<2;j++) {
           		a[j] =  ans.get(i).get(j);
           	}
           	arr[i] =  a;
           }
           
           return   arr;
   	
   	 // or 
   	 //  return ans.toArray(new int[0][]);
       
       
       
   }
}
