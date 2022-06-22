package graph;

import java.util.ArrayList;
import java.util.List;

public class clonegraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

//    public Node cloneGraph(Node node) {
//        if(node == null)return null;
//        var nodeMap = new HashMap<Integer, Node>();
//        var que = new LinkedList<Node>();
//        que.add(node);
//        while (!que.isEmpty()){
//            var t = que.removeFirst();
//            if (!nodeMap.containsKey(t.val))nodeMap.put(t.val, new Node(t.val));
//            if (t.neighbors != null){
//                for (Node n: t.neighbors){
//                    if (!nodeMap.containsKey(n.val)){
//                        nodeMap.put(n.val, )
//                    }
//                }
//            }
//        }
//    }

}
