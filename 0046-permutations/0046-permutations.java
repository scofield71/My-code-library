class Solution {
    void helper(List<Integer> current, List<List<Integer>> ans, int ndx) {
        if(ndx==current.size()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=ndx;i<current.size();i++) {
            Collections.swap(current,i,ndx);
            helper(current,ans,ndx+1);
            Collections.swap(current,i,ndx);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int i=0;i<nums.length;i++) current.add(nums[i]);
        helper(current,ans,0);
        return ans;
    }
}