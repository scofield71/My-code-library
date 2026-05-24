class Solution {
    void helper(int[] candidates, int target, int curSum, int ndx, List<List<Integer>> ans, List<Integer> current) {
        if(target==curSum) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if(curSum>target || ndx>=candidates.length) return;
        if((candidates[ndx]+curSum)<=target) {
            current.add(candidates[ndx]);
            helper(candidates,target,curSum+candidates[ndx],ndx,ans,current);
            current.remove(current.size()-1);
        }
        helper(candidates,target,curSum,ndx+1,ans,current);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(candidates,target,0,0,ans,current);
        return ans;
    }
}