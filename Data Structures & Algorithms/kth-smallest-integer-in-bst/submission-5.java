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
    int level;
    TreeNode kthNode;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        inOrderkthSmallest(root,k);
        return  kthNode.val;   
    }
    private void inOrderkthSmallest(TreeNode root, int k) {
        if(root == null) return;

        inOrderkthSmallest(root.left,k);
        
        level+=1;
        if(level == k)
        {
            kthNode = root;
            return;
        }
        inOrderkthSmallest(root.right,k);
    }
}