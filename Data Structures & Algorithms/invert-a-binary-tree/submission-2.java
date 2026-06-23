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
    public TreeNode invertTree(TreeNode root) 
    {
       invertTreeHelper(root); 
       return root;
    }

    private void invertTreeHelper(TreeNode node) 
    {
        if(node == null)
            return;
        
        TreeNode lt = node.left != null ? node.left : null;
        TreeNode rt = node.right != null ? node.right : null;
        
        TreeNode temp = lt;
        node.left = rt;
        node.right = temp;

        invertTreeHelper(node.right);
        invertTreeHelper(node.left);
    }
}
