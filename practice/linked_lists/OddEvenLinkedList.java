package linked_lists;

/**
 * Odd Even Linked List

 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example 1:

 Input: 1->2->3->4->5->NULL
 Output: 1->3->5->2->4->NULL
 Example 2:

 Input: 2->1->3->5->6->4->7->NULL
 Output: 2->3->6->7->1->5->4->NULL
 Note:

 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */

public class OddEvenLinkedList {
  public static void main(String[] args) {
    OddEvenLinkedList r = new OddEvenLinkedList();
    ListNode n = r.new ListNode(1);
    n.next = r.new ListNode(2);
    n.next.next = r.new ListNode(3);
    n.next.next.next = r.new ListNode(4);
    n.next.next.next.next = r.new ListNode(5);
    r.oddEvenList(n);
  }

  public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode odd = head, even = head.next, oddHead = head, evenHead = head.next;

    while (odd.next != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }

    odd.next = evenHead;

    return oddHead;
  }

  class ListNode {
    public int val;
    public ListNode next;
    ListNode(int v) {
      val = v;
      next = null;
    }
  }
}
