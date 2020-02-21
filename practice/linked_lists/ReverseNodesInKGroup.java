package linked_lists;

/**
 * Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    int size = 0;
    ListNode t = head;
    while (t != null) {
      size++;
      t = t.next;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    for (ListNode prev = dummy, tail = head; size >= k; size -= k) {
      for (int i = 1; i < k; i++) {
        ListNode temp = tail.next.next;
        tail.next.next = prev.next;
        prev.next = tail.next;
        tail.next = temp;
      }
      prev = tail;
      tail = tail.next;
    }
    return dummy.next;
  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }
}
