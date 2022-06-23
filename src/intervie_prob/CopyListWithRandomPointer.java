package intervie_prob;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node node = new Node(head.val);
        Node newHead = node;
        nodeMap.put(head, node);
        for (var temp = head; temp != null; temp = temp.next){
            if (temp!= head){
                node.next = new Node(temp.val);
                nodeMap.put(temp, node.next);
                node = node.next;
            }
        }
        Node tail = head;
        while (tail != null){
            if (tail.random != null){
                nodeMap.get(tail).random = nodeMap.get(tail.random);
            }
            tail = tail.next;
        }
        return newHead;
    }
}



