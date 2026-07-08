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
  public void reorderList(ListNode head) 
    {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 6 8 10

        //
        ListNode secondHalf = reverse(slow.next);//8 6
        slow.next = null;// 2 4 null

        ListNode firstHalf = head;// 2 4 6 8

        while(secondHalf!=null)
        {
            ListNode temp1 = firstHalf.next; //4 6 8
            ListNode temp2 = secondHalf.next; //6
            
            firstHalf.next = secondHalf;//2 8 6
            secondHalf.next = temp1;//8->temp1

            firstHalf = temp1;
            secondHalf = temp2;
        }

    }

    private ListNode reverse(ListNode node)
    {
       ListNode prev = null;
       ListNode next = null;
       ListNode curr = node;

       while(curr!=null)// 1 2 3 4
       {
        next = curr.next;//nx=2 3 4
        curr.next = prev;//1 null
        prev = curr;
        curr = next;
       } 
       return prev;
    }
}
