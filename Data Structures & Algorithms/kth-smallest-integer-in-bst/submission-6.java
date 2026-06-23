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
//Preorder LNR
class Solution {
    int level;
    int val;
    public int kthSmallest(TreeNode root, int k) {
        KthSmallestInorder(root,k);
        return val;
    }

    private void KthSmallestInorder(TreeNode root, int k) {
        if(root == null) return;

        KthSmallestInorder(root.left,k);
        level++;
        if(k==level)
        {
            val = root.val;
            return;
        }
        KthSmallestInorder(root.right,k);
    }
}
