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
        int maxLength;

        public int diameterOfBinaryTree(TreeNode root) 
        {
            diameterOfBinaryTreeHelper(root);
            return maxLength ;
        }

        public int diameterOfBinaryTreeHelper(TreeNode root) 
        {
            if(root == null)
            return 0;
        
            int leftLen = diameterOfBinaryTreeHelper(root.left);
            int righttLen = diameterOfBinaryTreeHelper(root.right);

            maxLength = Math.max(maxLength, leftLen+righttLen);

            return Math.max(leftLen, righttLen) + 1;
        }
    }
                                                                                                                    