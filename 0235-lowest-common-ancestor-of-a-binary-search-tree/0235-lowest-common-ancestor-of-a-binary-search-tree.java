/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    
    }
    public int helper(TreeNode root, TreeNode p,TreeNode q){
        if(root == null )return 0;

        int left = helper(root.left,p,q);
        int right = helper(root.right,p,q);
        int self = (root ==p || root == q)? 1:0;
        int total = left+self+right;
        if(total == 2 && ans == null){
            ans = root;
        }
        return total;
    }
}