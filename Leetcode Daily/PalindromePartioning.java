class Solution {
   	List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) return ans;

        boolean[][] dp = new boolean[len][len];
        //one character substring
        for(int i = 0; i < len; i++) dp[i][i] = true;

        //two characters substring
        for(int i = 0; i < len - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) dp[i][i + 1] = true;
        }

        for(int j = 2; j < len; j++){
            for(int i = 0; i < j; i++){
                if(i + 1 == j) continue;//two characters substring
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) dp[i][j] = true;
            }
        }

        dfs(s, 0, dp, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int start, boolean[][] dp, List<String> list){
        if(start == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(dp[start][i]){
                list.add(s.substring(start, i + 1));
                dfs(s, i + 1, dp, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
