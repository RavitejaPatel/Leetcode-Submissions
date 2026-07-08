# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow_ptr: ListNode = head
        fast_ptr: ListNode = head
        
        while slow_ptr is not None and fast_ptr is not None and fast_ptr.next is not None:
            slow_ptr = slow_ptr.next
            fast_ptr = fast_ptr.next.next

            if (slow_ptr is not None and fast_ptr is not None) and (slow_ptr.val == fast_ptr.val):
                return True
        return False
