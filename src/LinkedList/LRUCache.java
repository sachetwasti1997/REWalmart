package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node{
        int data;
        int key;
        Node prev;
        Node next;
        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + (prev != null ? prev.key : null) +
                    ", next=" + (next != null ? next.key : null) +
                    '}';
        }
    }

    Map<Integer, Node> nodeMap;
    Node head;
    Node tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
    }

    public void moveNodeToTop(int key){
        var node = nodeMap.get(key);
        if (node == head){
            return;
        }
        if (node == tail){
            tail = tail.prev;
        }
        var s = node.prev;
        var t = node.next;
        if (t != null){
            t.prev = s;
            s.next = t;
        }else{
            s.next = t;
        }
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)){
            return -1;
        }
        var node = nodeMap.get(key);
        if (node == head){
            return head.data;
        }
        moveNodeToTop(key);
        return node.data;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)){
            nodeMap.get(key).data = value;
            moveNodeToTop(key);
            return;
        }
        var node = new Node(key, value);
        nodeMap.put(key, node);
        if (capacity == 1 && count == 1){
            head = node;
            tail = node;
            return;
        }
        if (count >= capacity){
            nodeMap.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
            count --;
        }
        if (head == null){
            head = node;
            tail = node;
            count++;
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
        count++;
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        System.out.println(c.nodeMap);
    }

}
