package linked_lists;

/**
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesInPairs {
  // Recursive solution
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    head.next.next = swapPairs(head.next.next);
    ListNode n = head.next;
    head.next = head.next.next;
    n.next = head;
    head = n;
    return head;
  }

  // Iterative Solution
  private ListNode swapPairsIterative(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    dummy.next = head;
    while ((head != null) && (head.next != null)) {
      ListNode first = head;
      ListNode second = head.next;
      first.next = second.next;
      second.next = first;
      prev.next = second;
      head = first.next;
      prev = first;
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
