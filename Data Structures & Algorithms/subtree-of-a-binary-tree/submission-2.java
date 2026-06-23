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
        return isSameTreeHelper(root,subRoot);
    }

    private boolean isSameTreeHelper(TreeNode root, TreeNode subRoot)
    {
        if(root == null)
            return false;
        
        return
            isSameTree(root, subRoot) == true ? true : 
            (isSameTreeHelper(root.left, subRoot) || isSameTreeHelper(root.right, subRoot));

    } 


    // private boolean dfs(TreeNode node, TreeNode subRoot)
    // {

    //     if( (node == null && subRoot != null) || (node != null && subRoot == null) )
    //         return false;
        
    //     return 
    //         ( (node != null && subRoot != null && node.left == subRoot.left) ? dfs(node.left,subRoot) : false )
    //         &&
    //         ( (node != null && subRoot != null && node.right == subRoot.right) ? dfs(node.right,subRoot) : false );

    // }


    private boolean isSameTree(TreeNode node, TreeNode subRoot)
    {
        if(node == null && subRoot == null) return true;
        if( (node == null && subRoot != null) || (node != null && subRoot == null) ) return false;
        if(node.val != subRoot.val) return false;

        return 
            isSameTree(node.left, subRoot.left)
            &&
            isSameTree(node.right,subRoot.right);
    }
}
