class Solution {
public:
    bool isPossible(vector<int>& nums, int curNdx,vector<int>& mem) {
        if(curNdx==nums.size()-1) return true;
        if(mem[curNdx]!=-1) return mem[curNdx]==0?false:true;
        for(int i=curNdx+1;i<=(curNdx+nums[curNdx]) && i<nums.size();i++) {
            bool possible = isPossible(nums,i,mem);
            if(possible) return mem[curNdx]=true;
        }
        return mem[curNdx]=false;
    }
    bool canJump(vector<int>& nums) {
        int range = nums[0];
        for(int i=1;i<nums.size();i++) {
            if(range<i) return false;
            range = max(range,i+nums[i]);
        }
        return true;
    }
};