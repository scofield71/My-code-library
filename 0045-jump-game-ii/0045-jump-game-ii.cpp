class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()==1) return 0;
        int range = nums[0];
        int jumps = 1;
        int maxRange = nums[0];
        for(int i=1;i<nums.size();i++) {
            if(i>range) {
                range = maxRange;
                maxRange = max(maxRange,i+nums[i]);
                jumps++;
            } else {
                maxRange = max(maxRange,i+nums[i]);
            }
        }
        return jumps;
    }
};