package linked_lists;

public class LinkedListIntersection {
  public static void main(String[] args) {
    LinkedListIntersection lli = new LinkedListIntersection();
    ListNode a = lli.new ListNode(0);
    a.next = lli.new ListNode(9);
    a.next.next = lli.new ListNode(1);
    a.next.next.next = lli.new ListNode(2);
    a.next.next.next.next = lli.new ListNode(4);

    ListNode b = lli.new ListNode(3);
    b.next = a.next.next.next;

    System.out.println(lli.getIntersectionNode(a, b).val);
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    int sizeA = getSize(headA);
    int sizeB = getSize(headB);
    int diff = Math.abs(sizeA - sizeB);

    ListNode nodeA = headA;
    ListNode nodeB = headB;
    if (sizeA > sizeB) {
      while (diff > 0) {
        nodeA = nodeA.next;
        diff--;
      }
    } else if (sizeB > sizeA) {
      while (diff > 0) {
        nodeB = nodeB.next;
        diff--;
      }
    }

    while (nodeA.next != null || nodeB.next != null) {
      nodeA = nodeA.next;
      nodeB = nodeB.next;
      if (nodeA == nodeB) return nodeA;
    }

    return null;
  }

  private int getSize(ListNode node) {
    int size = 0;
    while (node.next != null) {
      size++;
      node = node.next;
    }
    return size;
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
