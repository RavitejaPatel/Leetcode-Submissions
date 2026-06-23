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
    public boolean hasCycle(ListNode head) 
    {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while( (slowPtr!=null) && (fastPtr!=null && fastPtr.next!=null ) )
        {
            slowPtr = slowPtr.next ;//2 3 4 // 3 4 // 4
            fastPtr = fastPtr.next.next;//3 4 // 2 //4

            if(slowPtr == fastPtr)
                return true;
        }    
        return false;
    }
}
