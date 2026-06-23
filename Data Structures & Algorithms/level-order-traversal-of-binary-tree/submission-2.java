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
	Queue<TreeNode> q = new LinkedList<>();
	List<List<Integer>> res = new ArrayList<>();
	
    public List<List<Integer>> levelOrder(TreeNode root) 
	{
		if(root == null)
			return res;
		
		q.add(root);
		levelOrderHelper(root);
		
		System.out.println(res);
		return res;
	}
	
	private void levelOrderHelper(TreeNode node)
	{
//		List<Integer> list=null;
		while(!q.isEmpty())
		{
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<size;i++)
			{
				TreeNode pop = q.poll();
				
				
				list.add(pop.val);
				
				if( pop.left!=null)
				{
					q.add(pop.left);
				}
				
				if(pop.right!=null)
				{
					q.add(pop.right);
				}
				
			}
			res.add(new ArrayList<>(list));
//			list.clear();
		}
	}
}
