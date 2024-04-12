package A_OnsiteClassical.Design;

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
    private final Map<Integer, Node> map;
    private final DoubleLinkedList cache;
    private final int capacity;

    public LRU(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node target = map.get(key);
        cache.remove(target);
        cache.addFirst(target);
        return target.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            cache.remove(target);

            target.val = value;
            cache.addFirst(target);

            return;
        }

        if (capacity == cache.getSize()) {
            Node removeOne = cache.removeLast();
            map.remove(removeOne.key);
        }

        Node cur = new Node(key, value);
        cache.addFirst(cur);
        map.put(key, cur);
    }
}

class DoubleLinkedList {
    private final Node head;
    private final Node tail;
    private int size;

    public DoubleLinkedList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public void addFirst(Node x) {
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        ++size;
    }

    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        --size;
    }

    public Node removeLast() {
        if (size == 0) {
            return null;
        }

        Node target = tail.prev;
        remove(target);
        return target;
    }

    public int getSize() {
        return this.size;
    }
}


class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


