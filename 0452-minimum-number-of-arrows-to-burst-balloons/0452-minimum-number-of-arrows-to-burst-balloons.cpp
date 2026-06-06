class Solution {
public:
    static bool comp(vector<int>& p, vector<int>& q) {
        return p[1]<q[1];
    }
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(),points.end(),comp);
        int ans = 0;
        for(int i=0;i<points.size();i++) {
            int end = points[i][1];
            int j=i+1;
            while(j<points.size() && points[j][0]<=end) j++;
            ans++;
            i=j-1;
        }
        return ans;
    }
};