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
    int level;
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewDFS(root, 0);
        return res;
    }

    public void rightSideViewDFS(TreeNode root,int currLevel)
    {
    	if(root==null)
    	{
    		return;
    	}
    	
    	if(currLevel == level)
    	{
    		level+=1;
    		res.add(root.val);
    	}
    	rightSideViewDFS(root.right, currLevel+1);
    	rightSideViewDFS(root.left, currLevel+1);
    	
    }

    // private void rightSideViewHelper(TreeNode root, int level) {
    //     if(root == null)
    //         return;

    //     if(level>=maxLevel)
    //     {
    //         res.add(root.val);
    //         maxLevel++;
    //     }

    //     rightSideViewHelper(root.right, level+1);
    //     rightSideViewHelper(root.left, level+1);
    // }

}
