class Solution {
public:
    vector<vector<int>> twoSum(vector<int>& nums,int i,int j,int target) {
        vector<vector<int>> ans;
        while(i<j) {
            int t = nums[i]+nums[j];
            if((nums[i]>0 && target<0) || (nums[j]<0 && target>0)) return ans;
            if(t>target) j--;
            else if(t<target) i++;
            else {
                ans.push_back({nums[i],nums[j]});
                i++;
                j--;
                while(i<nums.size() && nums[i]==nums[i-1]) i++;
                while(j>0 && nums[j]==nums[j+1]) j--;
            }
        }
        return ans;
    }
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        for(int i=0;i<nums.size();i++) {
            vector<vector<int>> tmp = twoSum(nums,i+1,nums.size()-1,-1*nums[i]);
            for(auto it:tmp) {
                it.push_back(nums[i]);
                ans.push_back(it);
            }
            i++;
            while(i<nums.size() && nums[i]==nums[i-1] ) i++;
            i--;
        }
        return ans;
    }
};