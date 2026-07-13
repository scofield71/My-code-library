class Solution {
    public int helper(String s, int st, int end) {
       if (st>end) return 0;
       if(st==end) return 1;
       int a = helper(s,st,end-1);
       int b = helper(s,st+1,end);
       int c = 0;
       if (s.charAt(st)==s.charAt(end)) {
         c = helper(s,st+1,end-1);
         if (c+2==end-st+1) {
            c+=2;
         } else c=0;
       }
       return Math.max(a,Math.max(b,c));
    }
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for (int i=0;i<s.length();i++) {
            for (int j=0;j<s.length();j++) {
                if (j<=i) dp[i][j]=true;
            }
        }
        int val = 1;
        String ans = String.valueOf(s.charAt(0));
        for (int k=2;k<=s.length();k++) {
            for (int i=0;i<s.length();i++) {
                int endx = i+k-1;
                if (endx<s.length() && s.charAt(i)==s.charAt(endx)) {
                    if (dp[i+1][endx-1]) {
                        dp[i][endx]=true;
                        if (val<endx-i+1) {
                            val = endx-i+1;
                            if (endx+1!=s.length()) ans = s.substring(i,endx+1);
                            else ans = s.substring(i);
                        }
                    }
                }
            }
        }
        System.out.println(val);
        return ans;
    }
}