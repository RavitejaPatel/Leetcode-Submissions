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
    int maxDiameter=-1;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return maxDiameter;
    }
    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null) return 0;

       int ltHeight = diameterOfBinaryTreeHelper(root.left);
       int rtHeight = diameterOfBinaryTreeHelper(root.right);

       maxDiameter = Math.max(maxDiameter, ltHeight+rtHeight);
        int ht = Math.max(
            ltHeight,
            rtHeight
        ) + 1;

        return ht;
    }

    
}
