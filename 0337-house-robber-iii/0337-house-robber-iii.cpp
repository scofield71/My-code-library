/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int robEasy(TreeNode* root, bool isRobbed,unordered_map<TreeNode*,vector<int>>& ourmap) {
        if(!root) return 0;
        if(ourmap.find(root)!=ourmap.end() && ourmap[root][isRobbed]!=-1) return ourmap[root][isRobbed];
        if(ourmap.find(root)==ourmap.end()) ourmap[root]=vector<int>(2,-1);
        if(isRobbed) {
            return ourmap[root][isRobbed]=robEasy(root->left,!isRobbed,ourmap) + robEasy(root->right,!isRobbed,ourmap);
        } 
        int a = root->val + robEasy(root->right,true,ourmap) + robEasy(root->left,true,ourmap);
        int b = robEasy(root->right,false,ourmap) + robEasy(root->left,false,ourmap);
        return ourmap[root][isRobbed]=max(a,b);
    }
    int rob(TreeNode* root) {
        unordered_map<TreeNode*,vector<int>> ourmap;
        return robEasy(root,false,ourmap);
    }
};