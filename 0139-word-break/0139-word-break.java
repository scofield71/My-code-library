class Solution {
    public boolean helper(String s, HashSet<String> ourset,int index,int[] dp) {
        if (index>=s.length()) return true;
        if (dp[index]!=-1) return dp[index]==1;
        for (int i=index;i<s.length();i++) {
            String sub = i!=s.length()-1 ? s.substring(index,i+1) : s.substring(index);
            if (ourset.contains(sub)) {
                boolean tmp = helper(s,ourset,i+1,dp);
                if (tmp) {
                    dp[index]=1;
                    return true;
                }
            }
        }
        dp[index]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        for (int i=0;i<s.length();i++) dp[i]=-1;
        HashSet<String> ourset = new HashSet<>();
        for (String st : wordDict) {
            ourset.add(st);
        }
        return helper(s,ourset,0,dp);
    }
}