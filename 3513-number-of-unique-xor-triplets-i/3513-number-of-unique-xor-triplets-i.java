class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length==1 || nums.length==2) return nums.length;
        int msb = 0;
        int num = nums.length;
        for(int i=0;i<=31;i++) {
            if ((num&(1<<i))==(1<<i)) msb = i;
        }
        return (int)Math.pow(2,msb+1);
    }
}