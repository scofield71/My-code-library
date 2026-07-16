class Solution {
    public int findGCD(int x,int y) {
        if (x<y) return findGCD(y,x);
        if (y==1) return y;
        if (x%y==0) return y;
        return findGCD(y,x%y);
    }
    public long gcdSum(int[] nums) {
        int mxnum = nums[0];
        int[] prefixGCD = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            mxnum = Math.max(mxnum,nums[i]);
            prefixGCD[i] = findGCD(mxnum,nums[i]);
        }
        Arrays.sort(prefixGCD);
        long sum = 0;
        int i=0,j=nums.length-1;
        while(i<j) {
            sum+=(long)(findGCD(prefixGCD[i],prefixGCD[j]));
            i++;
            j--;
        }
        return sum;
    }
}