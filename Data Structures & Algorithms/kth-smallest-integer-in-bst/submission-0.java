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
    int ct;
    TreeNode finalNode;

    public int kthSmallest(TreeNode root, int k) 
    {
        if(root == null)
            return -1;
        kthSmallestHelper(root,k);
        return finalNode.val;
    }

    private void kthSmallestHelper(TreeNode root, int k)
    {
        if(root == null)
            return;
        
        kthSmallestHelper(root.left, k);
        // if(left!=null)
        //     return left;
        
        ct++;
        if(ct==k)
        {
            finalNode = root;
            return;
        }
        kthSmallestHelper(root.right, k);
    }

}
