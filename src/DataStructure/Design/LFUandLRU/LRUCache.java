package DataStructure.Design.LFUandLRU;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        public int key, val;
        public Node next, prev;

        private Node(int k, int v) {
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

        public void addFirst(Node x) {
            Node headNext = head.next;
            head.next = x;
            headNext.prev = x;
            x.prev = head;
            x.next = headNext;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }

    private Map<Integer, Node> map;
    private DoubleList cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(n);
            map.put(key, n);
        } else {
            if (cache.size() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(n);
            map.put(key, n);
        }
    }
}
