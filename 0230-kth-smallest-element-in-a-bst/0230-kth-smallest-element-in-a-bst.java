/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode iterator = root;
        while(iterator!=null) {
            stk.push(iterator);
            iterator=iterator.left;
        }
        int count=0;
        while(!stk.isEmpty()) {
            if(count+1==k) return stk.peek().val;
            TreeNode tmp = stk.pop();
            count++;
            if(tmp.right!=null) {
                tmp = tmp.right;
                while(tmp!=null) {
                    stk.push(tmp);
                    tmp=tmp.left;
                }
            }
        }
        return 0;
    }
}