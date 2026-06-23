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

class Solution 
{
    TreeNode prev;
    public boolean isValidBST(TreeNode root) 
    {
        return isValidBSTHelper(root);
    }

    private boolean isValidBSTHelper(TreeNode node) 
    {
        if(node == null) return true;

        if(!isValidBSTHelper(node.left))
            return false;

        if(prev!=null && prev.val>=node.val)
        {
           return false;
        }
        prev = node;

        return isValidBSTHelper(node.right);
    }
}
