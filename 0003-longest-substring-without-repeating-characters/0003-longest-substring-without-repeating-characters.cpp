class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> mp(256,0);
        int i=0,j=0;
        int ans = 0;
        while(j<s.length()) {
            int val = s[j];
            if(mp[val]==0) {
                mp[val]++;
                j++;
            } else {
                ans = max(ans,j-i);
                while(i<j && mp[val]>0) {
                    int tmpVal = s[i];
                    mp[tmpVal]--;
                    i++;
                }
            }
        }
        ans=max(ans,j-i);
        return ans;
    }
};