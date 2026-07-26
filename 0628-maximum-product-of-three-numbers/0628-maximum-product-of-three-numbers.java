class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0]>=0 || nums[n-1]<=0) return nums[n-1]*nums[n-2]*nums[n-3];
        int a = nums[0]*nums[1]*nums[n-1];
        int b = nums[n-1]*nums[n-2]*nums[n-3];
        return Math.max(a,b);
    }
}