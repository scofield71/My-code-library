class Solution {
public:
    int robEasy(vector<int>& nums) {
        vector<int> dp(nums.size(),0);
        dp[0]=nums[0];
        for(int i=1;i<nums.size();i++) {
            if(i==1) dp[i]=max(dp[i-1],nums[i]);
            else dp[i]=max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.size()-1];
    }
    int rob(vector<int>& nums) {
        if(nums.size()==1) return nums[0];
        vector<int> firstHouse(nums.begin(),nums.begin()+nums.size()-1);
        vector<int> secondHouse(nums.begin()+1,nums.end());
        return max(robEasy(firstHouse),robEasy(secondHouse));
    }
};