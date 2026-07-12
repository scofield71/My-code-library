class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int[] dp = new int[nums.length];
        for (int i=0;i<nums.length;i++) dp[i]=Integer.MAX_VALUE;
        dp[0]=0;
        dp[1]=(nums[0]==0)? dp[1] : 1;
        for(int i=2;i<nums.length;i++) {
            for (int j=i-1;j>=0;j--) {
                if (dp[j]!=-1 && (nums[j]+j) >= i) {
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[nums.length-1]==Integer.MAX_VALUE ? -1 : dp[nums.length-1];
    }
}