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
        if(list1 == null || list2 == null)
            return list1==null ? list2 : list1;

        ListNode res = new ListNode();
        ListNode fres = res;

        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                ListNode curr = new ListNode(list1.val);
                res.next = curr;
                list1 = list1.next;
                //res = res.next;
            }
            else
            {
                ListNode curr = new ListNode(list2.val);
                res.next = curr;
                list2 = list2.next;
                //res = res.next;
            }
            res = res.next;
        }

        while(list1!=null)
        {
            ListNode curr = new ListNode(list1.val);
            res.next = curr;
            list1 = list1.next;
            res = res.next;
        }
        while(list2!=null)
        {
            System.out.println(list2.val+" ");
            ListNode curr = new ListNode(list2.val);
            res.next = curr;
            list2 = list2.next;
            res = res.next;
        }
       // res = res.next;

        return fres.next;

    }
}