class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        if(nums.size()==1) return 1;
        vector<int> evenSum;
        vector<int> oddSum;
        for(int i=0;i<nums.size();i++) {
            if(i==0) oddSum.push_back(nums[i]);
            else if(i==1) evenSum.push_back(nums[i]);
            else if (i%2==0){
                int val = oddSum[oddSum.size()-1];
                oddSum.push_back(val+nums[i]);
            } else {
                int val = evenSum[evenSum.size()-1];
                evenSum.push_back(val+nums[i]);
            }
        }
        int ans = 0;
        for(int i=0;i<oddSum.size();i++) {
            int odd=0,even=0;
            if(i==0) {
                odd = evenSum[evenSum.size()-1];
                even = oddSum[oddSum.size()-1]-oddSum[0];
            } else {
                odd = oddSum[i-1]+evenSum[evenSum.size()-1]-evenSum[i-1];
                even = evenSum[i-1]+oddSum[oddSum.size()-1]-oddSum[i];
            }
            if(odd==even) ans++;
        }

        for(int i=0;i<evenSum.size();i++) {
            int odd=0,even=0;
            if(i==0) {
                odd = oddSum[0] + evenSum[evenSum.size()-1]-evenSum[0];
                even = oddSum[oddSum.size()-1]-oddSum[0];
            } else {
                odd = oddSum[i] + evenSum[evenSum.size()-1]-evenSum[i];
                even = evenSum[i-1] + oddSum[oddSum.size()-1]-oddSum[i];
            }
            if(odd==even) ans++;
        }

        return ans;
    }
};