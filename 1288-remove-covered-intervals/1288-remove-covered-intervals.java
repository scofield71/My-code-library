class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int ans = 0;
        int st=0,end=0;
        for(int i=0;i<intervals.length;i++) {
            if (end<=intervals[i][0]) {
                ans++;
                st = intervals[i][0];
                end = intervals[i][1];
            } else {
                if (st<intervals[i][0] && end>=intervals[i][1]) {
                    continue;
                } else if (st==intervals[i][0]) {
                    end = Math.max(end,intervals[i][1]);
                } else {
                    ans++;
                    st = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }
        return ans;
    }
}