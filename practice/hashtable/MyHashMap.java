package hashtable;

import java.util.LinkedList;

/**
 Design HashMap
 Design a HashMap without using any built-in hash table libraries.

 To be specific, your design should include these functions:

 put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

 Example:

 MyHashMap hashMap = new MyHashMap();
 hashMap.put(1, 1);
 hashMap.put(2, 2);
 hashMap.get(1);            // returns 1
 hashMap.get(3);            // returns -1 (not found)
 hashMap.put(2, 1);          // update the existing value
 hashMap.get(2);            // returns 1
 hashMap.remove(2);          // remove the mapping for 2
 hashMap.get(2);            // returns -1 (not found)

 Note:

 All keys and values will be in the range of [0, 1000000].
 The number of operations will be in the range of [1, 10000].
 Please do not use the built-in HashMap library.
 */

public class MyHashMap {
  private LinkedList<Node>[] table;
  private final int DEFAULT_SIZE = 512;

  /** Initialize your data structure here. */
  public MyHashMap() {
    table = new LinkedList[DEFAULT_SIZE];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hashKey = hashCode(key);
    if (table[hashKey] != null) {
      LinkedList<Node> list = table[hashKey];
      for (Node n : list) {
        if (n.key == key) {
          n.value = value;
          return;
        }
      }
      list.add(new Node(key, value));
    } else {
      table[hashKey] = new LinkedList<>();
      table[hashKey].add(new Node(key, value));
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    int hashKey = hashCode(key);
    if (table[hashKey] != null) {
      for (Node n : table[hashKey]) {
        if (n.key == key) {
          return n.value;
        }
      }
    }
    return -1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hashKey = hashCode(key);
    if (table[hashKey] != null) {
      for (int i = 0; i < table[hashKey].size(); i++) {
        if (table[hashKey].get(i).key == key) {
          table[hashKey].remove(i);
        }
      }
    }
  }

  private int hashCode(int key) {
    return key % DEFAULT_SIZE;
  }

  class Node {
    int key;
    int value;
    Node(int k, int v) {
      key = k;
      value = v;
    }
  }
}
