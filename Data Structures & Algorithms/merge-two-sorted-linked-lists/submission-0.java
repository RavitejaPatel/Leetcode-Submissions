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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head = null;
        head = new ListNode(-1);
        ListNode res = head;
        ListNode curr = null;
        while(ptr1!=null && ptr2!=null)
        {
            if(ptr1.val<ptr2.val)
            {
                curr = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            }
            else
            {
               curr = new ListNode(ptr2.val);
               ptr2 = ptr2.next;
            }

            res.next = curr;
            res = res.next;
        }  
        while(ptr1!=null)
        {
            curr = new ListNode(ptr1.val);
            ptr1 = ptr1.next;

            res.next = curr;
            res = res.next;
        } 
        while(ptr2!=null)
        {
            curr = new ListNode(ptr2.val);
            ptr2 = ptr2.next;

            res.next = curr;
            res = res.next;
        } 

        return head.next;
    }
}