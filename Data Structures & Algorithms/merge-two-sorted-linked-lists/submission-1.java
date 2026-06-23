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
        ListNode res = new ListNode(0);
        ListNode head = res;

        while(list1!=null && list2!=null)
        {
            if(list1.val < list2.val)//
            {
                head.next = new ListNode(list1.val);// 0 1 1 2
                list1 = list1.next;
            }
            else
            {
                 head.next = new ListNode(list2.val);// 0 1    0 1 1 2 3
                 list2 = list2.next;
            }
            head = head.next;

        }

         head.next = list1!=null ?  list1 :  list2;

    return res.next;
    }
}