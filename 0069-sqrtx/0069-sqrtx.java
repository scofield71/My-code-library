class Solution {
    public int mySqrt(int x) {
        long low = 0, high = x;
        int ans = -1;
        while(low<=high) {
            long mid = low + (high-low)/2;
            long srq = mid*mid;
            if (srq<=(long)x) {
                ans = Math.max(ans,(int)mid);
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}