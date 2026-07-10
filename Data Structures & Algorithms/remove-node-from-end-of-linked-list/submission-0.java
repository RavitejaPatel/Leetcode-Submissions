/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
      	int len = getLLSize(head);
		
		if(len == n)
			return head.next;
		
		ListNode root = head;
		
		int i=1;
		while(i<(len-n) )
		{
			root = root.next;
			i++;
		}
		
		root.next = root.next.next;
		return head;  
    }


    private int getLLSize(ListNode node)
	{
		if(node == null) return 0;
		return 1+getLLSize(node.next);
	}
}
