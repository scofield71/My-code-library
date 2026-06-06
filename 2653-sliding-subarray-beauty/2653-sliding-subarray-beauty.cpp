class Solution {
public:
    vector<int> getSubarrayBeauty(vector<int>& nums, int k, int x) {
        unordered_map<int,int> ourmap;
        for(int i=0;i<k;i++) ourmap[nums[i]]++;
        vector<int> ans;
        int val = 0;
        for(int i=-50;i<0;i++) {
            val+=ourmap[i];
            if(val>=x) {
                ans.push_back(i);
                break;
            }
        }
        if(val<x) ans.push_back(0);
        for(int i=k;i<nums.size();i++) {
            ourmap[nums[i-k]]--;
            ourmap[nums[i]]++;
            val = 0;
            for(int j=-50;j<0;j++) {
                val+=ourmap[j];
                if(val>=x) {
                    ans.push_back(j);
                    break;
                }
            }
            if(val<x) ans.push_back(0);
        }
        return ans;
    }
};