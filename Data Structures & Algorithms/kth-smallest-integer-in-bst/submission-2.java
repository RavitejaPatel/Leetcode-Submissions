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
    int ct;
    TreeNode resultNode;

    public int kthSmallest(TreeNode root, int k) 
    {
        getkthSmallest(root,k);
        return resultNode.val;
    }

    private void getkthSmallest(TreeNode node, int k) 
    {
        if(node == null)
            return;
        
        getkthSmallest(node.left, k);

        ct++;
        if(ct == k)
        {
           resultNode = node;
           return; 
        }

        getkthSmallest(node.right, k);
    }
}



// class Solution 
// {
//     PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a,b) -> (b-a)
//     );
//     public int kthSmallest(TreeNode root, int k) 
//     {
//         //MaxHeap
//        getkthSmallest(root,k);
//         return pq.peek();
//     }

//     private void getkthSmallest(TreeNode node, int k)
//     {   
//         if(node == null)
//             return;
        
//         getkthSmallest(node.left,k);

//         pq.add(node.val);
//         if(pq.size()>k)
//             pq.remove();
        
//         getkthSmallest(node.right,k);
//     }
// }
