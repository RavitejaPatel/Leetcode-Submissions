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
    public ListNode reverseList(ListNode head) {
        //0 1 2 3
        ListNode prev = null;
        ListNode node = head;
        ListNode next = null;

        while(node!=null)
        {
            next = node.next;// 2 3 4
            node.next = null;//0 null ..2null
            node.next = prev;//0 null 2 0 null
            prev = node;//0-null 2 0 null
            node = next;//1 2 3 4  3 4
        }
        return prev;
    }
}
