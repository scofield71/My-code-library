class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        if (intervals.size()==0) return {newInterval};
        if (intervals[intervals.size()-1][1]<newInterval[0]) {
            intervals.push_back(newInterval);
            return intervals;
        }
        if (intervals[0][0]>newInterval[1]) {
            intervals.insert(intervals.begin(),newInterval);
            return intervals;
        }
        vector<vector<int>> ans;
        int check = 0;
        for(int i=0;i<intervals.size();i++) {
            if(intervals[i][1]>=newInterval[0] && check==0) {
                if (newInterval[1]<intervals[i][0]) {
                    ans.push_back(newInterval);
                    i--;
                    check=1;
                    continue;
                }
                int j = i;
                int start = min(newInterval[0],intervals[j][0]);
                int end = max(newInterval[1],intervals[j][1]);
                j++;
                while(j<intervals.size() && intervals[j][0]<=end) {
                    start = min(start,intervals[j][0]);
                    end = max(end,intervals[j][1]);
                    j++;
                }
                i=j-1;
                ans.push_back({start,end});
                check = 1;
            } else {
                cout<<i<<endl;
                ans.push_back(intervals[i]);
            }
        }
        return ans;
    }
};