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
        int ht = isBalancedHelper(root);
        System.out.print(ht);
        return ht!=-1;
    }

    public int isBalancedHelper(TreeNode root) 
    {
        if(root == null) return 0;

        int ltHt = isBalancedHelper(root.left);
        if(ltHt==-1) return -1;

        int rtHt = isBalancedHelper(root.right);
         if(rtHt == -1) return -1;

        if(Math.abs(ltHt-rtHt)>1) return -1;

        return Math.max(ltHt,rtHt)+1;
    }

}
