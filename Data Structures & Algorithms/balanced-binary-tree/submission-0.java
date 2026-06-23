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
    public boolean isBalanced(TreeNode root) 
    {

        if(root == null)
            return true;
        
        return isBalancedHelper(root) != -1;
        
    }

    public int isBalancedHelper(TreeNode root)
    {
        if(root == null)
            return 0;
        if(isLeafNode(root))
            return 1;
        
        int lh = isBalancedHelper(root.left);
        int rh = isBalancedHelper(root.right);

        if(lh ==-1 || rh == -1 || Math.abs(lh-rh) > 1 )
            return -1;

        return Math.max(lh,rh)+1;

    }

    private boolean isLeafNode(TreeNode node)
    {
        if(node.left == null && node.right == null)
            return true;
        return false;
    }


}
