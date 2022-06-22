package graph

import java.util.LinkedList

class ClonGraphRe {
    fun cloneGraph(node: Node?): Node? {
        if (node == null)return null
        val nodeMap = HashMap<Int?, Node?>()
        val que = LinkedList<Node>()
        while(!que.isEmpty()){
            var t = que.removeFirst()
            if (nodeMap[t.`val`] == null)nodeMap[t.`val`] = Node(t.`val`)
            for (i in t.neighbors){
                if (i != null && nodeMap[i.`val`] == null){
                    val c = Node(i.`val`)
                    nodeMap[i.`val`] = c
                    que.add(i)
                }
                if (i != null){
                    nodeMap[t.`val`]?.neighbors?.add(i)
                }
            }
        }
        return nodeMap[node.`val`]
    }
}