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
 public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
	 {
		 ListNode result = new ListNode();
		 ListNode temp = null;
		 ListNode head = result;
	       while(list1 != null && list2 != null)
	       {
	    	   if(list1.val < list2.val)
	    	   {
	    		   temp = new ListNode(list1.val, null);
//	    		   result.next = temp;
//	    		   result = result.next;
	    		   //result.next = (result == null) ? new ListNode(list1.val, null) : ;
	    		   list1 = list1.next;
	    	   }
	    	   else
	    	   {
	    		   temp = new ListNode(list2.val, null);//1
	    		   list2 = list2.next;
	    	   }
	    	   result.next = temp;//1 1 2 3 4 null
    		   result = result.next;
	       }
	       
	       while(list1!=null)
	       {
	    	   result.next = new ListNode(list1.val, null);
	    	   result = result.next;
	    	   list1 = list1.next;
	       }
	       
	       while(list2!=null)
	       {
	    	   result.next = new ListNode(list2.val, null);
	    	   result = result.next;
	    	   list2 = list2.next;
	       }
	       
	       return head.next;
	 }
	
}