package linked_lists;

/**
 * Remove Nth Node From End of List

 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.

 Follow up:

 Could you do this in one pass?
 */

public class RemoveNthNodeFromEnd {
  public static void main(String[] args) {
    RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
    ListNode n = r.new ListNode(1);
    n.next = r.new ListNode(2);
    n.next.next = r.new ListNode(3);
    n.next.next.next = r.new ListNode(4);
    n.next.next.next.next = r.new ListNode(5);
    r.removeNthFromEnd(n, 2);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = head;
    int size = 1;
    while (fast.next != null) {
      size++;
      fast = fast.next;
      if (fast.next == null) {
        int target = size - n + 1;
        int i = 1;
        while (i <= target-1) {
          prev = slow;
          slow = slow.next;
          i++;
        }
      }
    }
    if (slow == prev) {
      if (prev.next == null) {
        head = null;
      } else {
        head = head.next;
      }
    } else {
      prev.next = slow.next;
    }

    return head;
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
