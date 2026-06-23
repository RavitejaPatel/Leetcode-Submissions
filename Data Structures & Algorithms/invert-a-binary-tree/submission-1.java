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
    // public TreeNode invertTree(TreeNode root) 
	// {
	// 	TreeNode result = null;
		
	// 	if(root == null)
	// 		return null;
		
	// 	Queue<TreeNode> queue = new LinkedList<>();
	// 	queue.add(root);

	// 	while(!queue.isEmpty())
	// 	{
	// 		TreeNode curr = queue.poll();
	// 		TreeNode temp = curr.left;
	// 		curr.left = curr.right;
	// 		curr.right = temp;
			
	// 		if(curr.left!=null)
	// 			queue.add(curr.left);
	// 		if(curr.right!=null)
	// 			queue.add(curr.right);
	// 	}
	// 	return root;
    // }

    public TreeNode invertTree(TreeNode root) 
	{
        if(root == null)
            return root;
        invertTreeHelper(root);
        return root;    
    }

    private void invertTreeHelper(TreeNode root)
    {
        if(root == null)
            return;
        
        //if(root.left!=null) 
            TreeNode lt = root.left!=null ? root.left : null;
        //if(root.right!=null) 
            TreeNode rt = root.right!=null ? root.right : null;

        TreeNode temp = lt;

        root.left = rt;
        root.right = temp;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
