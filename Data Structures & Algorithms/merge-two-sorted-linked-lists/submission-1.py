# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        ptr1: ListNode = list1
        ptr2: ListNode = list2

        head: ListNode = None;
        head = ListNode(-1);
        res: ListNode = head;
        curr: ListNode = None;

        while ptr1 is not None and ptr2 is not None:
            if ptr1.val < ptr2.val:
                curr = ListNode(ptr1.val)
                ptr1 = ptr1.next
            else:
                curr = ListNode(ptr2.val)
                ptr2 = ptr2.next
            
            res.next = curr
            res = res.next
        
        while ptr1 is not None:
            curr = ListNode(ptr1.val)
            ptr1 = ptr1.next
            res.next = curr
            res = res.next
        
        while ptr2 is not None:
            curr = ListNode(ptr2.val)
            ptr2 = ptr2.next
            res.next = curr
            res = res.next

        return head.next



        
        