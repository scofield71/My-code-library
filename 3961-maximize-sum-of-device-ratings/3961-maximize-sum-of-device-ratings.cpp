class Solution {
public:
    static bool comp(vector<int>& a, vector<int>& b) {
        if(a.size()==1) return a[0]<b[0];
        if (a[1]==b[1]) return a[0]<b[0];
        return a[1]<b[1];
    }
    long long maxRatings(vector<vector<int>>& units) {
        for(int i=0;i<units.size();i++) sort(units[i].begin(),units[i].end());
        sort(units.begin(),units.end(),comp);
        // for (auto it:units) {
        //     for (auto pt:it) cout<<pt<<" ";
        //     cout<<endl;
        // }
        int lowestVal = units[0][0];
        long long ans = 0;
        for (int i=units.size()-1;i>0;i--) {
            if (units[i].size()==1) ans+=(long long)units[i][0];
            else {
                ans+=(long long)units[i][1];
                lowestVal = min(lowestVal,units[i][0]);
            }
        }
        ans+=(long long)lowestVal;
        return ans;
    }
};