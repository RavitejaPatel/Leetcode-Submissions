/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution 
{
    public Node copyRandomList(Node head) 
    {
        Map<Node,Node> map = new HashMap<>();

        Node current = head;

        while(current!=null)
        {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while(current!=null)
        {
            map.get(current).next = current.next != null ? map.get(current.next) : null;
            map.get(current).random = current.random != null ? map.get(current.random) : null;

            current = current.next;
        }
        return map.get(head);
    }
}
