class Solution {
    public int jump(int[] nums) {
        int nextJump = 0;
        int maxReachable = 0;
        int jumps = 0;
        for (int i=0;i<nums.length;i++) {
            if (maxReachable<i) return -1;
            maxReachable = Math.max(maxReachable,i+nums[i]);
            if (i==nums.length-1) return jumps;
            if (i==nextJump) {
                jumps++;
                nextJump = maxReachable;
            }
        }
        return jumps;
    }
}