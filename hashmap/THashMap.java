import java.util.ArrayList;

class THashMap<K, V> {
  private ArrayList<V>[] _map;
  private int key_size;
  private int value_size;

  public THashMap() {
    _map = new ArrayList[10];
    key_size = 0;
    value_size = 0;
  }

  public boolean add(K k, V v) {
    int key = getKey(k);
    if (_map[key] == null) {
      _map[key] = new ArrayList<>();
      key_size++;
    }
    value_size++;
    _map[key].add(v);    
    return true;
  }

  public ArrayList<V> get(K k) {
    int key = getKey(k);
    return _map[key];
  }

  private int getKey(K k) {
    return k.hashCode() % _map.length;
  }
}