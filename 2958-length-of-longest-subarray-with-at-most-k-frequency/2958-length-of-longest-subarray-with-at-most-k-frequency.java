class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i=0,j=0;
        HashMap<Integer,Integer> ourmap = new HashMap<>();
        int ans = 1;
        while(j<nums.length) {
            int val = ourmap.getOrDefault(nums[j],0);
            ans = Math.max(ans,j-i);
            if (val+1>k) {
                ourmap.put(nums[i],ourmap.get(nums[i])-1);
                i++;
            } else {
                 ourmap.put(nums[j],val+1);
                 j++;
            }
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}