/*
Hard

8749

132

Add to List
*/
//Share
//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
class Solution {
    public int largestRectangleArea(int[] heights) {
            
            Stack<Integer> st = new Stack<>();
            st.push(-1);
            int maxArea = 0;
            
            for(int i=0; i<=heights.length; i++){
            int val  = i == heights.length?0:heights[i];
                
            while(st.peek() != -1 && heights[st.peek()] >= val){
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea,h*(rm-lm-1));
            }
                st.push(i);
            }    
            return maxArea;
                
            
        
    }
}
