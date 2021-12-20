 Minimum Absolute Difference
 
 class Solution {
   public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int n = arr.length;
		for( int i = 1; i < n; ++i ){
            if( arr[i]- arr[i-1] < min_diff ) 
                min_diff = Math.abs(arr[i]- arr[i-1]);
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for( int i = 1; i < n; ++i ) {
            List<Integer> temp = new ArrayList<Integer>();
            if( arr[i]- arr[i-1] == min_diff ) {
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                list.add(temp);
            }
        }
        return list;
    }
}
