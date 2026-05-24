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
    void helper(TreeNode root, List<String> paths, String path) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            if(path.length()==0) path+=String.valueOf(root.val);
            else path = path + "->" + String.valueOf(root.val);
            paths.add(path);
            return;
        }
        String a = (path.length()==0) ? String.valueOf(root.val) : path + "->" + String.valueOf(root.val);
        helper(root.left,paths,a);
        helper(root.right,paths,a);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        String path = "";
        helper(root,paths,path);
        return paths;
    }
}