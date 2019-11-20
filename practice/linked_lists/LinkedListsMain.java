package linked_lists;

class LinkedListsMain {
  public static void main(String[] args) {
    LinkedListsMain llm = new LinkedListsMain();

    int[] a = { 1, 2, 3, 4 };
    Node first = llm.createList(a);
    Node second = new Node(8);
    second.next = first.next.next;

    Node loop = new Node(1);
    loop.append(2);
    loop.append(3);
    loop.append(4);
    // loop.next.next.next.next = loop.next;

    // llm.printList(first);
    // llm.printList(second);
    LinkedLists ll = new LinkedLists();
    System.out.println(ll.loopDetection(loop).data);
    // System.out.println(ll.intersection(first, second).data);
    // System.out.println(ll.isPalindrome(head));
    // ll.printList(rd.removeDup(head)); 
    // ll.printList(rd.removeDupNoBuffer(head));
    // System.out.println(rd.kethfromlast(head, 4).data);
    // rd.deleteMiddleNode(head, 3);
    // llm.printList(ll.partition(head, 3));

    // Node n1 = new Node(9);
    // n1.append(7);
    // n1.append(8);

    // Node n2 = new Node(6);
    // n2.append(8);
    // n2.append(5);
    // n2.append(4);

    // llm.printList(ll.sumListsForward(n1, n2));
  }

  Node createList(int[] list) {
    Node head = null;
    for (int i = 0; i < list.length; i++) {
      if (head == null) {
        head = new Node(list[i]);
      } else {
        head.append(list[i]);
      }
    }
    return head;
  }

  void printList(Node head) {
    Node n = head;
    System.out.print(n.data + " ");
    while (n.next != null) {
      System.out.print(n.next.data + " ");
      n = n.next;
    }
    System.out.println();
  }
}
