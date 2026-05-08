class Solution {
public:
    vector<vector<int>> twoSum(vector<int>& nums,long long target, int i,int j) {
        vector<vector<int>> ans;
        if(i>=j) return ans;
        while(i<j) {
            long long sum = (long long)nums[i]+(long long)nums[j];
            if(sum<target) i++;
            else if(sum>target) j--;
            else {
                ans.push_back({nums[i],nums[j]});
                i++;
                while(i<j && nums[i]==nums[i-1]) i++;
                j--;
                while(j>i && nums[j]==nums[j+1]) j--;
            }
        }
        return ans;
    }
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        for(int i=0;i<nums.size();i++) {
            for(int j=i+1;j<nums.size();j++) {
                long long p = (long long)target - (long long)nums[i] - (long long)nums[j];
                vector<vector<int>> tmp = twoSum(nums,p,j+1,nums.size()-1);
                for(auto it:tmp) {
                    it.push_back(nums[i]);
                    it.push_back(nums[j]);
                    ans.push_back(it);
                }
                int k = j+1;
                while(k<nums.size() && nums[k]==nums[k-1]) k++;
                j=k-1;
            }
            int k = i+1;
            while(k<nums.size() && nums[k]==nums[k-1]) k++;
            i=k-1;
        }
        return ans;
    }
};