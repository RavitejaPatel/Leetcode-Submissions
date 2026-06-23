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
    List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> levelOrder(TreeNode root) 
    {
		if(root == null)
			return result;
		
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        getLevelOrder(root,queue, result);
        
        return result;
    }
	
	private void getLevelOrder(TreeNode root, Queue<TreeNode> queue, List<List<Integer>> result)
	{
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			
			for(int i=0;i<size;i++)
			{
				TreeNode curr = queue.poll();
				temp.add(curr.val);
				
				if(curr!=null && curr.left!=null )
					queue.add(curr.left);
				if(curr!=null && curr.right!=null )
					queue.add(curr.right);
			}
			result.add(temp);
		}
		
	}
}
