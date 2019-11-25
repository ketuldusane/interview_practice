package linked_lists;

import java.util.ArrayList;

/**
 * Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

public class Palindrome {
  public static void main(String[] args) {
    Palindrome p = new Palindrome();
    ListNode l = p.new ListNode(-129);
    l.next = p.new ListNode(-129);
    System.out.println(p.isPalindrome(l));
  }

  public boolean isPalindrome(ListNode head) {
    ArrayList<Integer> a = new ArrayList<>();
    ListNode node = head;
    while (node != null) {
      a.add(node.val);
      node = node.next;
    }

    int start = 0;
    int end = a.size() - 1;

    while (start < end) {
      if (!a.get(start).equals(a.get(end))) return false;
      start++;
      end--;
    }

    return true;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
