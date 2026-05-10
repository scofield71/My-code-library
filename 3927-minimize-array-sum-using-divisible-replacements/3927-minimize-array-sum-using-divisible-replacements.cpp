class Solution {
public:
    long long minArraySum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        unordered_map<int,int> ourmap;
        set<int> processed;
        for(auto it:nums) ourmap[it]++;
        for(int i=0;i<nums.size();i++) {
            if (processed.find(nums[i])==processed.end()) {
                int val = nums[i]*2;
                while(val<=1e5 && val<=nums[nums.size()-1]) {
                    if(ourmap[val]>0) {
                        ourmap[nums[i]]+=ourmap[val];
                        ourmap[val]=0;
                    }
                    val+=nums[i];
                }
                processed.insert(nums[i]);
            }
        }
        long long ans = 0;
        for(auto it:ourmap) {
            long long p = (long long)((long long)it.first*(long long)it.second);
            ans+=p;
        }
        return ans;
    }
};