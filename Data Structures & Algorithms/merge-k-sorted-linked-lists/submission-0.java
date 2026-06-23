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
 public ListNode mergeKLists(ListNode[] lists) 
  {
	if(lists.length<=0)
		return null;
	
	int interval = 1;
	int len = lists.length;
	
	while(interval<len)
	{
		for(int i=0;i<len-interval;i+=(2*interval))
		{
			lists[i] = mergeTwoSortedLL(lists[i], lists[i+interval]);
		}
		interval*=2;
	}
	return lists[0];
  }
  
  private ListNode mergeTwoSortedLL(ListNode node1, ListNode node2)
  {
	  if(node1==null && node2==null)
		  return null;
	  
	  ListNode tmp = new ListNode();
	  ListNode finalList = tmp;
	  
	  while(node1!=null && node2!=null)
	  {
		  if(node1.val < node2.val)
		  {
			  tmp.next = node1;
			  node1 = node1.next;
		  }
		  else
		  {
			  tmp.next = node2;
			  node2 = node2.next; 
		  }
		  tmp = tmp.next;
	  }
	  
	  tmp.next = node1 != null ? node1 : node2;
	  return finalList.next;
  }
}
