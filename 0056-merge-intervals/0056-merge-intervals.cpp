class Solution {
public:
    static bool comp(vector<int>& a, vector<int>& b) {
        return a[0]<b[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),comp);
        int start = intervals[0][0], end = intervals[0][1];
        vector<vector<int>> ans;
        for(int i=1;i<intervals.size();i++) {
            if(end<intervals[i][0] ) {
                ans.push_back({start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            } else {
                start = min(start,intervals[i][0]);
                end = max(end,intervals[i][1]);
            }
        }
        ans.push_back({start,end});
        return ans;
    }
};