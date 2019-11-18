package hashtable;

import java.util.LinkedList;

/**
 Design a HashSet without using any built-in hash table libraries.

 To be specific, your design should include these functions:

 add(value): Insert a value into the HashSet.
 contains(value) : Return whether the value exists in the HashSet or not.
 remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

 Example:

 MyHashSet hashSet = new MyHashSet();
 hashSet.add(1);
 hashSet.add(2);
 hashSet.contains(1);    // returns true
 hashSet.contains(3);    // returns false (not found)
 hashSet.add(2);
 hashSet.contains(2);    // returns true
 hashSet.remove(2);
 hashSet.contains(2);    // returns false (already removed)

 Note:

 All values will be in the range of [0, 1000000].
 The number of operations will be in the range of [1, 10000].
 Please do not use the built-in HashSet library.
 */

public class MyHashSet {
  public static void main(String[] args) {
    String[] command = new String[]{"add","add","contains","contains","add","contains","remove","contains"};
    int[] commmandVal = new int[]{1,2,1,3,2,2,2,2};
    String[] commandAns = new String[]{};

    MyHashSet hs = new MyHashSet();
    for (int i = 0; i < command.length; i++) {
      switch (command[i]) {
        case "contains":
          boolean ans = hs.contains(commmandVal[i]);
//          if (!String.valueOf(ans).equals(commandAns[i])) {
//            i = i;
//          }
          break;
        case "remove":
          hs.remove(commmandVal[i]);
          break;
        case "add":
          hs.add(commmandVal[i]);
          break;
      }
    }
  }

  private LinkedList<Integer>[] table;
  private final int DEFAULT_SIZE = 512;

  /** Initialize your data structure here. */
  public MyHashSet() {
    table = new LinkedList[DEFAULT_SIZE];
  }

  public void add(int key) {
    LinkedList<Integer> n;
    int hashKey = hashCode(key);

    if (table[hashKey] == null) {
      n = new LinkedList<>();
      n.add(key);
      table[hashKey] = n;
    } else {
      n = table[hashKey];
      if (!n.contains(key)) {
        n.add(key);
      }
    }
  }

  public void remove(int key) {
    int hashKey = hashCode(key);
    if (table[hashKey] != null) {
      LinkedList<Integer> n = table[hashKey];

      if (n.contains(key)) {
        n.remove(new Integer(key));
      }
    }
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int hashKey = hashCode(key);
    LinkedList<Integer> n = table[hashKey];
    if (n != null) {
      return n.contains(key);
    }
    return false;
  }

  private int hashCode(int value) {
    return value % DEFAULT_SIZE;
  }

//  class Node {
//    int key;
//    Node next;
//    Node(int k) {
//      key = k;
//    }
//  }
}
