package linked_lists;

import java.util.HashMap;
import java.util.Stack;

public class LinkedLists {
  public Node removeDup(Node head) {
    HashMap<Integer, Integer> elems = new HashMap<>();
    Node curr = head;
    Node prev = null;
    while (curr.next != null) {
      if (elems.containsKey(curr.data)) {
        prev.next = curr.next;
      } else {
        elems.put(curr.data, 0);
        prev = curr;
      }
      curr = curr.next;
    }
    if (elems.containsKey(curr.data)) {
      prev.next = null;
    }
    return head;
  }

  public Node removeDupNoBuffer(Node head) {
    Node current = head;
    while(current != null) {
      Node runner = current;
      while (runner.next != null) {
        if (runner.next.data == current.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
    return head;
  }

  public Node kethfromlast(Node head, int k) {
    Node p1 = head;
    Node p2 = head;
    for (int i = 0; i < k; i++) {
      if (p1 == null) return null;
      p1 = p1.next;
    }

    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p2;
  }

  public void deleteMiddleNode(Node head, int d) {
    Node n = head.next;
    Node prev = head;
    while (n.next != null) {
      if (n.data == d) {
        prev.next = n.next;
        break;
      } else {
        prev = n;
        n = n.next;
      } 
    }
  }

  public Node partition(Node node, int x) {
    Node head = node;
    Node tail = node;

    while (node != null) {
      Node next = node.next;
      if (node.data < x) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;

    return head;
  }

  public boolean isPalindrome(Node head) {
    if (head == null || head.next == null) {
      return false;
    }

    Stack<Integer> stack = new Stack<>();
    Node slow = head;
    Node fast = head;

    while (fast != null) {
      stack.push(slow.data);
      slow = slow.next;

      if (fast.next == null) {
        stack.pop();
        break;
      } else if (fast.next.next == null) {
        break;
      }
      fast = fast.next.next;
    }

    while (slow != null) {
      if ((Integer) stack.pop() != slow.data) {
        return false;
      }
      slow = slow.next;
    }

    return true;
  }

  public Node loopDetection(Node head) {
    if (head == null || head.next == null) {
      return null;
    }
    Node slow = head;
    Node fast = head;
    while (fast != null || fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }

  public Node intersection(Node first, Node second) {
    ListMetadata fld = getTailandSize(first);
    ListMetadata sld = getTailandSize(second);

    if (fld.tail != sld.tail) {
      return null;
    }

    Node shorter = fld.size > sld.size ? second : first;
    Node longer = fld.size < sld.size ? second : first;

    longer = chopList(longer, Math.abs(fld.size - sld.size));
    while (shorter != longer) {
      shorter = shorter.next;
      longer = longer.next;
    }

    return longer;
  }

  ListMetadata getTailandSize(Node head) {
    if (head == null)
      return null;

    int size = 1;
    Node current = head;
    while (current.next != null) {
      size++;
      current = current.next;
    }
    return new ListMetadata(current, size);
  }

  class ListMetadata {
    Node tail;
    int size;

    ListMetadata(Node t, int s) {
      tail = t;
      size = s;
    }
  }

  Node chopList(Node head, int size) {
    if (head == null)
      return null;
    Node n = head;
    while (size > 0 && n != null) {
      n = n.next;
      size--;
    }
    return n;
  }

  public Node sumListsReverse(Node n1, Node n2) {
    if (n1 == null && n2 == null)
      return null;
    if (n1 == null && n2 != null)
      return n2;
    if (n1 != null && n2 == null)
      return n1;

    Node result = null;
    Node m = n1, n = n2;
    int sum = 0, carry = 0;
    while (m != null || n != null) {
      if (m != null)
        sum += m.data;
      if (n != null)
        sum += n.data;
      sum += carry;
      carry = sum / 10;
      sum = sum % 10;

      if (result == null) {
        result = new Node(sum);
      } else {
        result.append(sum);
      }

      if (m != null)
        m = m.next;
      if (n != null)
        n = n.next;

      sum = 0;
    }

    if (carry != 0) {
      result.append(carry);
    }

    return result;
  }

  public Node sumListsForward(Node n1, Node n2) {
    Node m = null;
    Node n = null;

    while (n1 != null || n2 != null) {
      m = addToLeft(n1, m);
      n = addToLeft(n2, n);

      if (n1 != null)
        n1 = n1.next;
      if (n2 != null)
        n2= n2.next;
    }
    return sumListsReverse(m, n);
  }

  private Node addToLeft(Node subject, Node target) {
    if (subject != null) {
      if (target == null) {
        target = new Node(subject.data);
        target.next = null;
      } else {
        Node x = new Node(subject.data);
        x.next = target;
        target = x;
      }
    }
    return target;
  }
}
