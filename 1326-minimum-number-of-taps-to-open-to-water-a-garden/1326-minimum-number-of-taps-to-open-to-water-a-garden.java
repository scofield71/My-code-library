class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jumpArray = new int[n+1];
        for (int i=0;i<ranges.length;i++) {
            int min = Math.max(0,i-ranges[i]);
            int max = Math.min(n,i+ranges[i]);
            jumpArray[min] = Math.max(max,jumpArray[min]);
        }
        int jumps = 0;
        int curNdx = 0;
        int maxReach = 0;
        for (int i=0;i<jumpArray.length;i++) {
            if (maxReach<i) return -1;
            maxReach = Math.max(maxReach,jumpArray[i]);
            if (curNdx==i && curNdx!=jumpArray.length-1) {
                curNdx = maxReach;
                jumps++;
            }
        }
        return jumps;
    }
}