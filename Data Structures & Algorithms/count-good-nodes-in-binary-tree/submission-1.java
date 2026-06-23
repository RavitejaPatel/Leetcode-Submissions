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
    int goodNodeCt;
    
    public int goodNodes(TreeNode root) 
    {
      getGoodNodes(root,-101);  
       return goodNodeCt; 
    }

    private void getGoodNodes(TreeNode node, int prevGoodNode)
    {
        if(node == null)
            return;
        
        if(node.val >= prevGoodNode)
        {
            prevGoodNode = node.val;
            goodNodeCt+=1;
        }
        getGoodNodes(node.left,prevGoodNode);
        getGoodNodes(node.right,prevGoodNode);
    }
}
