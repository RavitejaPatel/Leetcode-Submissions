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
    int preOrderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,inorder,0,preorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int st, int ed) {
        if(st>ed) return null;
        TreeNode node = new TreeNode(preorder[preOrderIdx++]);
        
        if(st == ed) return node;

        int inOrdIdx = getInOrderIndexOfCurrNode(inorder,node.val);
        node.left = buildTreeHelper(preorder,inorder, st, inOrdIdx-1);
        node.right = buildTreeHelper(preorder,inorder, inOrdIdx+1,ed);

        return node;
    }

    private int getInOrderIndexOfCurrNode(int[] inorder, int preOrdVal) {

        int i=0;
        //int index = -1;
        while(i<inorder.length) {
            if(inorder[i] == preOrdVal) return i;
            i++;
        }
        return -1;
    }
}
