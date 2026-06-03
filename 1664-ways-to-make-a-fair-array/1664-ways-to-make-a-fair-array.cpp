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

        for(int i=0;i<nums.size();i++) {
            int ndx = i/2;
            int odd = 0, even = 0;
            if(i%2==0) {
                if(i==0) {
                    odd = evenSum[evenSum.size()-1];
                    even = oddSum[oddSum.size()-1]-oddSum[0];
                } else {
                    odd = oddSum[ndx-1] + evenSum[evenSum.size()-1]-evenSum[ndx-1];
                    even = evenSum[ndx-1]+oddSum[oddSum.size()-1]-oddSum[ndx];
                }
            } else {
                if(i==1) {
                    odd = oddSum[0] + evenSum[evenSum.size()-1]-evenSum[0];
                    even = oddSum[oddSum.size()-1]-oddSum[0];
                } else {
                    odd = oddSum[ndx] + evenSum[evenSum.size()-1]-evenSum[ndx];
                    even = evenSum[ndx-1] + oddSum[oddSum.size()-1]-oddSum[ndx];
                }
            }
            if(odd==even) ans++;
        }

        return ans;
    }
};