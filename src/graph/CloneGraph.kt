package graph

import java.util.LinkedList
import kotlin.collections.HashMap

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        if(node == null)return null
        val nodeMap = HashMap<Int?, Node?>()
        val que = LinkedList<Node>()
        que.add(node)
        while(!que.isEmpty()){
            val temp = que.poll()
            if(nodeMap[temp.`val`] == null)nodeMap[temp?.`val`] = Node(temp.`val`)
            for(i in temp.neighbors){
                if(i != null && nodeMap[i.`val`] == null){
                    val c = Node(i.`val`)
                    que.add(i)
                    nodeMap[i.`val`] = c
                }
                if (i != null){
                    nodeMap[temp.`val`]?.neighbors?.add(nodeMap[i.`val`])
                }
            }
        }
        return nodeMap[node.`val`]
    }
}

fun main(){
    val v = CloneGraph()
    val root = Node(1)
    val v2 = Node(2)
    val v3 = Node(3)
    val v4 = Node(4)
    root.neighbors.add(v2)
//    v.cloneGraph()
}