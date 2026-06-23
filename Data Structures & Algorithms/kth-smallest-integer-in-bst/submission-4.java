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
    TreeNode kthNode;
    int idx;

    public int kthSmallest(TreeNode root, int k) 
    {
        kthSmallestInorder(root,k);
        return kthNode.val;
    }

    private void kthSmallestInorder(TreeNode node, int k) 
    {
        if(node == null)
            return;
        
        kthSmallestInorder(node.left, k);
        idx += 1;

        if(idx == k)
        {
           kthNode = node;
           return; 
        }
        kthSmallestInorder(node.right, k);
    }
}
