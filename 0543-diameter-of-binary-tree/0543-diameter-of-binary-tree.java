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
    Pair<Integer,Integer> helper(TreeNode root) {
        if(root==null) return new Pair<Integer,Integer>(0,0);
        Pair<Integer,Integer> l = helper(root.left);
        Pair<Integer,Integer> r = helper(root.right);
        Integer rootHeight = Math.max(l.getValue(),r.getValue()) + 1;
        Integer rootDiameter = l.getValue() + r.getValue();
        Integer maxDiameter = Math.max(rootDiameter,Math.max(l.getKey(),r.getKey()));
        return new Pair<Integer,Integer>(maxDiameter,rootHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).getKey();
    }
}