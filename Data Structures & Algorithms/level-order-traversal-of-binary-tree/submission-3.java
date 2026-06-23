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
    public List<List<Integer>> levelOrder(TreeNode root) 
	{
        Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		q.add(root);
		levelOrderHelper(root,q,res);
		return res;
	}
	private void levelOrderHelper(TreeNode root,Queue<TreeNode> q,List<List<Integer>> res)
	{
		if(root == null) return ;
		
		while(!q.isEmpty())
		{	
			int qsize = q.size();
			
			List<Integer> temp = new ArrayList();

			for(int i=0;i<qsize;i++)
			{
				TreeNode curr = q.poll();
				//System.out.println(qsize+" ");
				temp.add(curr.val);
				if(curr!=null && curr.left !=null)
					q.add(curr.left);
				if(curr!=null && curr.right!=null)
					q.add(curr.right);
			}
			System.out.println(temp);
			res.add(temp);
		}

	}
}
