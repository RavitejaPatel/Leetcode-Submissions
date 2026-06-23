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
    int greaterCt;
    public int goodNodes(TreeNode root) 
    {
        if(root == null)
            return 0;

        int greaterSoFar = root.val;
        //int greaterCt = 0;

        goodNodesHelper(root, greaterSoFar);
        return greaterCt;
    }

    private void goodNodesHelper(TreeNode root, int greaterSoFar)
    {
        if(root == null)
            return ;
        
         if(root!=null && root.val>=greaterSoFar)
        {
            System.out.println(greaterCt);
            greaterSoFar = root.val;
            greaterCt+=1;
        }

        goodNodesHelper( root.left,  greaterSoFar);
        goodNodesHelper( root.right,  greaterSoFar);
    }
}
