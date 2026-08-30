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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);//10 8
        slow.next = null; // 2 4 8 null
        ListNode firstHalf = head;

        while(secondHalf!=null)
        {
            ListNode temp1 = firstHalf.next;//4 8
            ListNode temp2 = secondHalf.next;//4 8

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
        }
    }
    private ListNode reverse(ListNode root)
    {
        ListNode node = root;
        ListNode prev = null;
        ListNode next = null;

        while(node != null)// 8 10
        {
            next = node.next;//10 null
            node.next =  null;//8 - null 10-null
            node.next = prev;//8->null 10->8->null 
            prev=node;//10->8->null 
            node = next;//10 null
        }
        return prev;
    }
}
