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
        ListNode prev = null;
        ListNode next = head;
        ListNode curr = head;

        while(curr!=null)//0 1 2 3
        {
            next = curr.next; // 1 2 3
            curr.next = prev;// 0 null
            prev = curr;//0 null
            curr = next;
        }
    return prev;
    }
}
