package linked_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K Sorted Lists
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new ListNodeComparator());
    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }

    ListNode head = new ListNode(0);
    ListNode point = head;

    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      if (node.next != null) {
        queue.add(node.next);
      }
      point.next = new ListNode(node.val);
      point = point.next;
    }

    return head.next;
  }

  class ListNodeComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
      if (a.val < b.val) {
        return -1;
      } else if (a.val > b.val) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
