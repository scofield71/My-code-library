class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        if(nums.size()==1) return 0;
        vector<int> prefix(nums.size(),0);
        vector<int> suffix(nums.size(),0);
        prefix[0] = nums[0];
        suffix[nums.size()-1]=nums[nums.size()-1];
        for(int i=1;i<nums.size();i++) {
            prefix[i]=nums[i]+prefix[i-1];
            suffix[nums.size()-i-1] = suffix[nums.size()-i]+nums[nums.size()-i-1];
        }
        int ans = 0;
        for(int i=0;i<nums.size();i++) {
            if(i==0) {
                if(suffix[i+1]==0) return 0;
            } else if (i==nums.size()-1) {
                if(prefix[i-1]==0) return i;
            } else {
                if(prefix[i-1]==suffix[i+1]) return i;
            }
        }
        return -1;
    }
};