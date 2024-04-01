package A_OnsiteClassical;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.get(2);
    }
    // each Node has its Integer index
    private Map<Integer, Node> map;
    private DoubleLinkedList cache;
    private int cap;

    public LRU(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleLinkedList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        priority(key);
        Node cur = map.get(key);
        return cur.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        // filled
        if (cache.getSize() == cap) {
            removeLeastRecently();
        }

        addRecently(key, value);
    }

    private void priority(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node insert = new Node(key, val);
        cache.addLast(insert);
        map.put(key, insert);
    }

    private void deleteKey(int key) {
        Node delete = map.get(key);
        cache.remove(delete);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node target = cache.removeFirst();
        int key = target.key;
        map.remove(key);
    }
}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleLinkedList {
    private Node head, tail;
    private int size;

    public DoubleLinkedList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // 每次删减或增加都注意tail/head和x
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
        // nothing inside list
        if (head.next == tail) {
            return null;
        }

        Node target = head.next;
        remove(target);
        return target;
    }

    public int getSize() {
        return this.size;
    }
}


