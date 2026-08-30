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
            first = first.next;//1 2 3 4  // 2 3 4
            n-=1;
        }

        while(first!=null)
        {
            second = second.next;//1 2 3 4 // 2 3 4 // 3 4
            first = first.next;//3 4   4 null
        }

        second.next = second.next.next;//4

        return dummy.next;

    }
}
