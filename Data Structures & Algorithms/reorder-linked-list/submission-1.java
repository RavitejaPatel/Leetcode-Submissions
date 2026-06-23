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


public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        int len = getLength(head);
        int mid = (len - 1) / 2;         // end index of the first half

        // advance to node at 'mid'
        ListNode firstEnd = head;
        for (int i = 0; i < mid; i++) firstEnd = firstEnd.next;

        // reverse the second half (start at firstEnd.next)
        ListNode second = reverse(firstEnd.next);
        firstEnd.next = null;            // split

        // weave first half [head..firstEnd] with reversed second half
        ListNode first = head;
        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }

    private int getLength(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) n++;
        return n;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

