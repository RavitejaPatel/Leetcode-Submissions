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
    public ListNode reverseKGroup(ListNode head, int k) 
    {

        if(head == null)
            return null;
        
        ListNode a = head;//4 5
        ListNode b = head;// 4 5
       
        for(int i=0;i<k;i++)//1 2
        {
            if(b==null)
                return head;
            b = b.next;//5 6
        }
        
        ListNode updatedHead = reverseList(a,b);//3 2 1
       a.next = reverseKGroup(b,k);

       return updatedHead;
    }

    private ListNode reverseList(ListNode a, ListNode b) 
    {
        ListNode prev = null;
        ListNode next = a;
        ListNode curr = a;

        while(curr!=b)//0 1 2 3
        {
            next = curr.next; // 1 2 3
            curr.next = prev;// 0 null
            prev = curr;//0 null
            curr = next;
        }
    return prev;
    }
}
