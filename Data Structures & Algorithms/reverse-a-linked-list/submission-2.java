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
    public ListNode reverseList(ListNode head) 
    {
        if(head ==  null) return head;

        ListNode node = head;
        ListNode prev = null;
        ListNode next = null;
        //ListNode current = node;

        // while(current != null)
        // {
        //     node = current;
        //     next = node.next;
        //     node.next = prev;
        //     prev = node;
        //     current = next;
        // }

        while(node != null)
        {
            next = node.next;
            node.next = null;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
