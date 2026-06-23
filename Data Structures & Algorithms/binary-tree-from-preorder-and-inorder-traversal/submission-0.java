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
    int preOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return buildTreeHelper(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int st, int ed)
    {
        if(st>ed)
            return null;

        TreeNode node = new TreeNode(preorder[preOrder++]);

        if(st == ed)
            return node;
        
        int inorderIdx = getInOrderInder(inorder, node.val);
        node.left = buildTreeHelper(preorder, inorder, st,inorderIdx-1);
        node.right = buildTreeHelper(preorder, inorder,inorderIdx+1, ed);

        return node;
    }

    private int getInOrderInder(int[] inorder, int val)
    {
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
}
