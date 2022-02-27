package middle;

import java.util.HashMap;

public class MyLRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;//额定容量
    // int size; //当前容量
    HashMap<Integer, Node> map;
    Node dummyHead;
    Node dummyTail;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        // size = 0;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        addToHead(node);

        return node.value;
    }

    private void addToHead(Node node) {
        node.next = dummyHead.next;
        dummyHead.next.pre = node;
        dummyHead.next = node;
        node.pre = dummyHead;
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }


    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            if (map.size() > capacity) {
                map.remove(dummyTail.pre.key);
                removeNode(dummyTail.pre);
            }
            addToHead(node);
        } else {
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }


    public static void main(String[] args) {
        MyLRUCache lruCache = new MyLRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
