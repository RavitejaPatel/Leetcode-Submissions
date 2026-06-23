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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode l1Rev = l1;//reverse(l1);
        ListNode l2Rev = l2;//reverse(l2);

        int carry = 0;
        int sum = 0;
        ListNode head = null;
         ListNode prev = null;

        while(l1Rev!=null || l2Rev!=null)
        {
           sum = carry 
                    + 
                  (l1Rev!=null ? l1Rev.val : 0)   
                    +
                    (l2Rev!=null ? l2Rev.val : 0);
            carry = sum/10;
            ListNode node = new ListNode(sum%10);

            if(head == null)
            {
                head = node;
            }
            else
            {
                prev.next = node;
            }

            prev = node;
            if(l1Rev !=null) l1Rev = l1Rev.next;
            if(l2Rev !=null) l2Rev = l2Rev.next;
        }

        if(carry!=0)
        {
            prev.next = new ListNode(carry);
        }
        //head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode node) 
    {
        ListNode prev = null, curr = node, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
