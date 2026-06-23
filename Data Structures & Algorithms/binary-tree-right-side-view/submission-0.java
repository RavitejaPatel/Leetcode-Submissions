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
    int maxLevel;
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(root, 0);
        return res;
    }

    private void rightSideViewHelper(TreeNode root, int level) {
        if(root == null)
            return;

        if(level>=maxLevel)
        {
            res.add(root.val);
            maxLevel++;
        }

        rightSideViewHelper(root.right, level+1);
        rightSideViewHelper(root.left, level+1);
    }

}
