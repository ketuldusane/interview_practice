package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {
  // Using a doubly linked list
  private int capacity;
  private int currentCapacity;
  private Node head;
  private Node tail;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    currentCapacity = 0;
    map = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      deleteNode(node);
      addToHead(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.val = value;
      deleteNode(node);
      addToHead(node);
    } else {
      if (currentCapacity == capacity) {
        Node remove = tail.prev;
        deleteNode(remove);
        map.remove(remove.key);
        currentCapacity--;
      }
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      addToHead(newNode);
      currentCapacity++;
    }
  }

  private void addToHead(Node node) {
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
    head.next = node;
  }

  private void deleteNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private static class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int k, int v) {
      key = k;
      val = v;
    }
  }

  /*
  private PriorityQueue<Item> queue;
  private HashMap<Integer, Item> map;

  private int capacity = 0;
  private int currentCapacity = 0;
  private int age = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    queue = new PriorityQueue<>(capacity, new ItemComparator());
    map = new HashMap<>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Item item = map.get(key);
      queue.remove(item);
      item.age = age;
      queue.add(item);
      age++;
      return item.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    Item item;
    if (map.containsKey(key)) {
      item = map.get(key);
      queue.remove(item);
      item.value = value;
      item.age = age;
      queue.add(item);
    } else {
      if (currentCapacity == capacity) {
        Item remove = queue.remove();
        map.remove(remove.key);
        currentCapacity--;
      }
      item = new Item(key, value, age);
      map.put(key, item);
      queue.add(item);
      currentCapacity++;
    }
    age++;
  }

  class ItemComparator implements Comparator<Item> {
    public int compare(Item a, Item b) {
      if (a.age < b.age) {
        return -1;
      } else if (a.age > b.age) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  class Item {
    int key;
    int value;
    int age;

    Item(int k, int v, int a) {
      key = k;
      value = v;
      age = a;
    }
  }
   */

  public static void main(String[] args) {
    /*
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
    [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     */
    LRUCache l = new LRUCache(2);
    l.put(1, 1);
    l.put(2, 2);
    l.get(1);
    l.put(3, 3);
    l.get(2);
    l.put(4, 4);
    l.get(1);
    l.get(3);
    l.get(4);
  }
}