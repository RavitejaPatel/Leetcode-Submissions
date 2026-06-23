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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if(root == null)
            return false;

        return isSubtreeHelper(root, subRoot);
    }

    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot)
    {
        if(root == null)
            return false;
        if(isSameTree(root,subRoot))
            return true;
       return isSubtreeHelper(root.left, subRoot) || isSubtreeHelper(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p.val != q.val) return false;
        
        return 
            isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
