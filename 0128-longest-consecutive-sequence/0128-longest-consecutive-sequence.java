class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> ourmap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            ourmap.putIfAbsent(nums[i],true);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            int tmpAns = 0;
            if(ourmap.containsKey(nums[i])) {
                tmpAns = 1;
                int val = nums[i]-1;
                ourmap.remove(nums[i]);
                while(ourmap.containsKey(val)) {
                    ourmap.remove(val);
                    val--;
                    tmpAns++;
                }
                val = nums[i]+1;
                while(ourmap.containsKey(val)) {
                    ourmap.remove(val);
                    val++;
                    tmpAns++;
                }
            }
            ans = Math.max(ans,tmpAns);
        }
        return ans;
    }
}