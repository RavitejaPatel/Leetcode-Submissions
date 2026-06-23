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

class Solution 
{
   public ListNode removeNthFromEnd(ListNode head, int n) 
   {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode firstNode = dummy;
      ListNode secondNode = dummy;

      while(firstNode != null && n>=0)
      {
         firstNode = firstNode.next;
         n-=1;
      }
      while(firstNode!=null && secondNode != null)
      {
         firstNode = firstNode.next;
         secondNode = secondNode.next;
      }
      secondNode.next = secondNode.next.next;
      
      return dummy.next;
   }
}
