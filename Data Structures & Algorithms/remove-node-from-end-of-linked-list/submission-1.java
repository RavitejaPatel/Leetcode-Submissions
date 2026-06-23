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
     ListNode first = dummy;
     ListNode second = dummy;


     while(first!=null && n>=0)
     {
        first = first.next;
        n-=1;
     }

     while(first!=null)
     {
        second = second.next;
        first = first.next;
     }

     second.next = second.next.next;

     return dummy.next;

    }
}
