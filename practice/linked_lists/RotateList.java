package linked_lists;

/**
 * Rotate List

 Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) return head;
    ListNode curr = head, prev = null;
    int size = 0;
    while(curr != null) {
      size++;
      if (curr.next == null) {
        curr.next = head;
        break;
      }
      curr = curr.next;
    }
    curr = head;
    int count = size - (k % size) + 1;
    int i = 0;
    while (i < count - 1) {
      i++;
      prev = curr;
      curr = curr.next;
    }
    prev.next = null;
    head = curr;
    return head;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
