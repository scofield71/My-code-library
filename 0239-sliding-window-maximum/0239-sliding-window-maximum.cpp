class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<vector<int>> dq;
        for(int i=0;i<k;i++) {
            while(dq.size()>0 && dq.back()[0]<nums[i]) dq.pop_back();
            dq.push_back({nums[i],i});
        }
        vector<int> ans;
        ans.push_back(dq.front()[0]);
        for(int i=k;i<nums.size();i++) {
            int skip = i-k;
            while(dq.size()>0 && dq.front()[1]<=skip) dq.pop_front();
            while(dq.size()>0 && dq.back()[0]<nums[i]) dq.pop_back();
            dq.push_back({nums[i],i});
            ans.push_back(dq.front()[0]);
        }
        return ans;
    }
};