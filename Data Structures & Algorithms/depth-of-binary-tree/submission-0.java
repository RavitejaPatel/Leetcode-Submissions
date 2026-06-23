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
    public int maxDepth(TreeNode root) 
    {
        if(root == null)
            return 0;
        return getMaxDepth(root);
    }
    private int getMaxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        
        return calcMxDepth(
                getMaxDepth(root.left),
                getMaxDepth(root.right)
            )+1;

    }

    private int calcMxDepth(int a,int b)
    {
        return Math.max(a,b);
    }
}
