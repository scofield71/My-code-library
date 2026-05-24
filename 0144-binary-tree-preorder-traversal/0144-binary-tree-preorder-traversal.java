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
    public List<Integer> preorderTraversal(TreeNode root) {
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
                // ans.add(traverse.val);
                traverse=traverse.right;
            } else if(nearestLeft.right==null) {
                ans.add(traverse.val);
                nearestLeft.right=traverse;
                traverse=traverse.left;
            }
        }
        return ans;
    }
}