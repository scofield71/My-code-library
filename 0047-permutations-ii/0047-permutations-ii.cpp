class Solution {
public:
    void helper(vector<int>& nums,vector<vector<int>>& ans,int ndx) {
        if(ndx==nums.size()) {
            ans.push_back(nums);
        }
        set<int> visited;
        for(int i=ndx;i<nums.size();i++) {
            int tmp = nums[i];
            if(i==ndx) {
                helper(nums,ans,ndx+1);
                visited.insert(nums[i]);
            }
            else if (visited.find(nums[i])==visited.end()) {
                visited.insert(nums[i]);
                swap(nums[i],nums[ndx]);
                helper(nums,ans,ndx+1);
                swap(nums[ndx],nums[i]);
            }
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        // sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        helper(nums,ans,0);
        return ans;
    }
};