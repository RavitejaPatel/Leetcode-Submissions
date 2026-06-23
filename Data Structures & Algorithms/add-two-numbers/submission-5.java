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


        // 1 2 3  3 -> 7 -> 1
        // 4 5 6  6 -> 5 -> 4
        //        9   
        //        9   2 (1c)   
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
                head = node;//9
            }
            else
            {
                prev.next = node;//9 -> 7
            }

            prev = node;//9 null  9 -> 7

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

}
