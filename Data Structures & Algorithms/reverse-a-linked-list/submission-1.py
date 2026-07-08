# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if(head is None):
            return head
        return self.reverseListHelper(head)
    

    def reverseListHelper(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev: ListNode = None
        curr: ListNode = head
        node: ListNode = None
        # prev = None
        # curr = head

        while curr is not None:
            node = curr.next
            curr.next = prev
            prev = curr
            curr = node
        return prev
        


        