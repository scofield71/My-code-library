class Solution {
    public void helper(int[] nums, int size, int ndx, HashSet<List<Integer>> uniqueSet, List<Integer> current) {
        if(ndx>=size) {
            uniqueSet.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[ndx]);
        helper(nums,size,ndx+1,uniqueSet,current);
        current.remove(Integer.valueOf(nums[ndx]));
        helper(nums,size,ndx+1,uniqueSet,current);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        List<Integer> current = new ArrayList<>();
        HashSet<List<Integer>> uniqueSet = new HashSet<>();
        helper(nums,size,0,uniqueSet,current);
        List<List<Integer>> ans = new ArrayList<>(uniqueSet);
        return ans;
    }
}