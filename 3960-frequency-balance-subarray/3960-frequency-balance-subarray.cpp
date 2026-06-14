class Solution {
public:
    int getLength(vector<int>& nums) {
        int ans = 0;
        for (int i=0;i<nums.size();i++) {
            unordered_map<int,int> freqmap;
            unordered_map<int,int> freqval;
            for(int j=i;j<nums.size();j++) {
                int val = freqval[nums[j]];
                if (val>0) {
                    freqmap[val]--;
                    if (freqmap[val]==0) freqmap.erase(val);
                } 
                freqval[nums[j]]++;
                freqmap[val+1]++;
                if (freqmap.size()==1) {
                    if (freqval.size()==1) ans = max(ans,j-i+1);
                }
                else if (freqmap.size()==2){
                    int k=0,s=0;
                    for (auto it:freqmap) {
                        if (k==0) k = it.first;
                        else s = it.first;
                    }
                    if (k==2*s || s==2*k) ans = max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
};