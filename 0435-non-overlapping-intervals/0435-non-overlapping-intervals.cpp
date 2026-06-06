class Solution {
public:
    static bool comp(vector<int>& a, vector<int>& b) {
        return a[1]<b[1];
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),comp);
        int ans = 0;
        for(int i=0;i<intervals.size();i++) {
            int end = intervals[i][1];
            int j=i+1;
            while(j<intervals.size() && intervals[j][0]<end) j++;
            ans+=(j-i-1);
            i=j-1;
        }
        return ans;
    }
};