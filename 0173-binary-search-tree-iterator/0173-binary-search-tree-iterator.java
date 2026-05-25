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
class BSTIterator {
    Stack<TreeNode> iterator;
    public BSTIterator(TreeNode root) {
        iterator = new Stack<>();
        TreeNode pointer = root;
        while(pointer!=null) {
            iterator.push(pointer);
            pointer = pointer.left;
        }
    }
    
    public int next() {
        TreeNode tmp = iterator.peek();
        iterator.pop();
        if(tmp.right!=null) {
            TreeNode t = tmp.right;
            while(t!=null) {
                iterator.push(t);
                t=t.left;
            }
        }
        return tmp.val;      
    }
    
    public boolean hasNext() {
        return !iterator.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */