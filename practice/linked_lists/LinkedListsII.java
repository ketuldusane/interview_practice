package linked_lists;

/**
 * Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow-up:
 * Can you solve it without using extra space?
 */

public class LinkedListsII {
  public static void main(String[] args) {
    LinkedListsII linkedListsII = new LinkedListsII();
    ListNode head = linkedListsII.new ListNode(3);
    head.next = linkedListsII.new ListNode(2);
    head.next.next = linkedListsII.new ListNode(0);
    head.next.next.next = linkedListsII.new ListNode(4);
    head.next.next.next.next = head.next;
    linkedListsII.detectCycle(head);
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null) return head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
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
