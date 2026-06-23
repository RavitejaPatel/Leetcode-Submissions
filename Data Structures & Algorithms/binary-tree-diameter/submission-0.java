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
      int diameter=0;
      int height;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root == null)
            return 0;
        
       diameterUtil(root);
        return diameter;
    }

    private int diameterUtil(TreeNode root)
    {
        if(root == null)
            return 0;
            
        int leftSideHeight = diameterUtil(root.left);
        int rightSideHeight = diameterUtil(root.right);
        diameter = Math.max(diameter, leftSideHeight+rightSideHeight);

        return getMax(
            leftSideHeight,
            rightSideHeight
            ) 
            + 1;
    }

    private int getMax(int a , int b)
    {
        return Math.max(a,b);
    }
        
}
