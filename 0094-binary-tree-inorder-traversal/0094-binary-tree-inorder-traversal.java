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
    void helper(TreeNode root, List<Integer> inorder) {
        if(root==null) return;
        helper(root.left,inorder);
        inorder.add(root.val);
        helper(root.right,inorder);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode traverse = root;
        while(traverse!=null) {
            TreeNode nearestLeft = traverse.left;
            while(nearestLeft!=null && nearestLeft.right!=traverse) {
                if(nearestLeft.left==null && nearestLeft.right==null) break;
                if(nearestLeft.right!=null) nearestLeft=nearestLeft.right;
                else break;
            }
            if(nearestLeft==null) {
                ans.add(traverse.val);
                traverse=traverse.right;
            } else if(nearestLeft.right==traverse) {
                nearestLeft.right=null;
                ans.add(traverse.val);
                traverse=traverse.right;
            } else if(nearestLeft.right==null) {
                nearestLeft.right=traverse;
                traverse=traverse.left;
            }
        }
        return ans;
    }
}