package linked_lists;

/**
 * Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeSorted {
  public static void main(String[] args) {
    MergeSorted m = new MergeSorted();
    ListNode a = m.new ListNode(-9);
    a.next = m.new ListNode(3);
    ListNode b = m.new ListNode(5);
    b.next = m.new ListNode(7);
    m.mergeTwoLists(a, b);
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode node = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        node.next = new ListNode(l1.val);
        node = node.next;
        l1 = l1.next;
      } else if (l1.val > l2.val) {
        node.next = new ListNode(l2.val);
        node = node.next;
        l2 = l2.next;
      } else {
        node.next = new ListNode(l1.val);
        node = node.next;
        node.next = new ListNode(l2.val);
        node = node.next;
        l1 = l1.next;
        l2 = l2.next;
      }
    }

    if (l2 != null) {
      node.next = l2;
    }
    if (l1 != null) {
      node.next = l1;
    }

    return head.next;
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
