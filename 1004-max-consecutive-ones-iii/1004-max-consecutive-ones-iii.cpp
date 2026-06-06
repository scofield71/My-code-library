class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int i=0,j=0;
        int ans = 0;
        int count = 0;
        while(j<nums.size()) {
            if(nums[j]==0) count++;
            if(count>k) {
                while(count>k) {
                    ans = max(ans,j-i);
                    if(nums[i]==0) count--;
                    i++;
                }
            } 
            j++;
        }
        ans = max(ans,j-i);
        return ans;
    }
};