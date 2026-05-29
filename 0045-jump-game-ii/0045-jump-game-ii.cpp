class Solution {
public:
    int jump(vector<int>& nums) {
        vector<int> dp(nums.size(),INT_MAX);
        dp[0]=0;
        for(int i=1;i<nums.size();i++) {
            for(int j=i-1;j>=0;j--) {
                int maxReach = nums[j]+j;
                if(maxReach>=i) dp[i]=min(dp[i],dp[j]+1);
            }
        }
        return dp[nums.size()-1];
    }
};