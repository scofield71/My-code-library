class Solution {
public:
    int jump(vector<int>& nums) {
        vector<int> dp(nums.size(),INT_MAX);
        dp[0]=0;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        pq.push({0,nums[0]});
        for(int i=1;i<nums.size();i++) {
            while(pq.size()>0 && pq.top().second<i) pq.pop();
            if(pq.size()>0) {
                dp[i]=pq.top().first+1;
                pq.push({dp[i],i+nums[i]});
            }
            else dp[i]=INT_MAX;
        }
        return dp[nums.size()-1];
    }
};