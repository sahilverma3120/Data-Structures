class Solution {
    public boolean canReach(int[] arr, int start) {
       return helper(arr,start,new boolean[arr.length]);
    }
    public static boolean helper(int []arr,int start,boolean visited[]){
      
        if(start<0){
            return false;
            
        }
        if(start>arr.length-1){
            return false;
        }
          if(visited[start]==true){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        visited[start]=true;
        boolean a=helper(arr,start+arr[start],visited);
        boolean b= helper(arr,start-arr[start],visited);
        return a||b;
    }
}
