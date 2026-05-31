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
        // vector<int> mem(nums.size()+1,-1);
        // return isPossible(nums,0,mem);
        vector<bool> dp(nums.size()+1,false);
        dp[0]=true;
        for(int i=1;i<nums.size();i++) {
            
            for(int j=i-1;j>=0;j--) {
                if(dp[j] && j+nums[j]>=i) {
                    dp[i]=true;
                    break;
                } 
            }
        }
        return dp[nums.size()-1];
    }
};