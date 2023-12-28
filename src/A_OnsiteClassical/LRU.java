package A_OnsiteClassical;

import java.util.HashMap;
import java.util.Map;

public class LRU {
  private Map<Integer, Node> map;
  private DoubleList cache;
  private int cap;

  public LRU(int cap) {
    this.cap = cap;
    map = new HashMap<>();
    cache = new DoubleList();
  }

  private void makeRecently(int key) {
    Node x = map.get(key);
    cache.remove(x);
    cache.addLast(x);
  }

  private void addRecently(int key, int val) {
    Node x = new Node(key, val);
    cache.addLast(x);
    map.put(key, x);
  }

  private void deleteKey(int key) {
    Node x = map.get(key);
    cache.remove(x);
    map.remove(key);
  }

  private void removeLeastRecently() {
    Node deletedNode = cache.removeFirst();
    int deletedKey = deletedNode.key;
    map.remove(deletedKey);
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    makeRecently(key);
    return map.get(key).val;
  }

  public void put(int key, int val) {
    if (map.containsKey(key)) {
      deleteKey(key);
      addRecently(key, val);
      return;
    }

    if (cap == cache.getSize()) {
      removeLeastRecently();
    }
    addRecently(key, val);
  }
}

class Node {
  public int key, val;
  public Node next, prev;
  public  Node(int k, int v) {
    this.key = k;
    this.val = v;
  }
}

class DoubleList {
  private Node head, tail;
  private int size;

  public DoubleList() {
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.next = head;
    size = 0;
  }

  public void addLast(Node x) {
    x.prev = tail.prev;
    x.next = tail;

    tail.prev.next = x;
    tail.prev = x;
    ++size;
  }

  public void remove(Node x) {
    x.prev.next = x.next;
    x.next.prev = x.prev;
    --size;
  }

  public Node removeFirst() {
    if (head.next == tail) {
      return null;
    }

    Node first = head.next;
    remove(first);
    return first;
  }

  public int getSize() {
    return size;
  }
}
