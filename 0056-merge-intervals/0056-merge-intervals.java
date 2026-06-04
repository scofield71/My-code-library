class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0],b[0]);
            }
        });
        List<List<Integer>> arr = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]>end) {
                arr.add(List.of(start,end));
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }
        }
        arr.add(List.of(start,end));
        int[][] ans = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++) {
            ans[i][0] = arr.get(i).get(0);
            ans[i][1] = arr.get(i).get(1);
        }
        return ans;
    }
}