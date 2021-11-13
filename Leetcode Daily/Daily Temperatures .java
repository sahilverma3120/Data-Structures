class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            throw new IllegalArgumentException("Input is null");
        }

        int len = temperatures.length;
        int[] result = new int[len];
        if (len <= 1) {
            return result;
        }

       
        for (int i = len - 2; i >= 0; i--) {
         

            int k = i + 1;
            while (temperatures[i] >= temperatures[k] && result[k] != 0) {
                
                k += result[k];
            }
            if (temperatures[i] < temperatures[k]) {
               
                result[i] = k - i;
            }
        }

        return result;
    }
}
