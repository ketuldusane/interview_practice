class MHashMap<K, V> {
  private Node<K, V> table[];
  private int size;

  private final int DEFAULT_TAB_LENGTH = 64;

  MHashMap() {
    table = new Node[DEFAULT_TAB_LENGTH];
    size = 0;
  }

  class Node<K, V> {
    private final int hash;
    private final K key;
    private V value;
    private Node<K, V> next;

    Node(int h, K k, V v) {
      hash = h;
      key = k;
      value = v;
      next = null;
    }

    K getKey() { return key; }
    V getValue() { return value; }
    int getHash() { return hash; }
    Node<K, V> getNext() { return next; }
    void setNext(Node<K, V> n) { next = n; }
    void setValue(V v) { value = v; }
  }

  public int size() { return size; }
  public boolean isEmpty() { return table.length == 0; }

  public V put(K key, V value) {
    return putVal(hash(key), key, value);
  }

  private V putVal(int hash, K key, V value) {
    int i;
    Node<K, V> p;

    i = hash % (table.length);

    if (table[i] == null) {
      table[i] = new Node(hash, key, value);
    } else {
      p = table[i];

      do {
        if (p.getNext() == null || p.getNext().getNext() == null) {
          p.setNext(new Node(hash, key, value));
          break;
        }
      } while (p.getNext() != null);
    }

    return value;
  }

  final int hash(Object key) {
    int h;
    return key.hashCode();
  }
}