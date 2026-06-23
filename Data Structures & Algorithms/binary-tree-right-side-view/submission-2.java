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
	int level =0;
    public List<Integer> rightSideView(TreeNode root) 
	{
		List<Integer> result = new ArrayList();
        rightSideViewDFS(root,0,result);
		return result;
    }
	private void rightSideViewDFS(TreeNode root, int currLevel, List<Integer> result)
	{
		if(root == null) return;

		if(level == currLevel) 
		{
			level+=1;
			result.add(root.val);
		}
		rightSideViewDFS(root.right,currLevel+1,result);
		rightSideViewDFS(root.left,currLevel+1,result);

	}
}
