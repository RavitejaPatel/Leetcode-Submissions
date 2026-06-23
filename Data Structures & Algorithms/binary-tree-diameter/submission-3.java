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
    int maxDiameter  = 0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
       diameterOfBinaryTreeHelper(root);
       return maxDiameter ; 
    }

    private int diameterOfBinaryTreeHelper(TreeNode root)
    {
        if(root == null) return 0;

        int leftHeight = diameterOfBinaryTreeHelper(root.left);
        int rightHeight = diameterOfBinaryTreeHelper(root.right);

        maxDiameter = Math.max(maxDiameter,leftHeight+rightHeight);
        
        return Math.max(leftHeight,rightHeight)+1;
    }

}
