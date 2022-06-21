package graph

import java.util.PriorityQueue
import kotlin.math.abs

data class EdgesX(var v: String, var weight: Int)

fun minCostConnectPoints(points: Array<IntArray>): Int {
    val graph = HashMap<String, ArrayList<EdgesX>>()
    for (i in points){
        for (j in points){
            if (i[0] == j[0] && i[1] == j[1])continue
            val key = "${i[0]} ${i[1]}"
            if (graph[key] == null)graph[key] = ArrayList()
            val w = abs(i[0]-j[0]) + abs(i[1]-j[1])
            graph[key]?.add(EdgesX("${j[0]} ${j[1]}", w))
        }
    }
    val pq = PriorityQueue<Pair<String, Int>>(points.size){a,b -> a.second - b.second}
    pq.add(Pair("${points[0][0]} ${points[0][1]}", 0))
    val visited = HashSet<String>(points.size)
    var total = 0
    while (visited.size < points.size){
        val t = pq.poll()
        if (!visited.contains(t.first)){
            for (i in graph[t.first] ?: ArrayList()){
                if (!visited.contains(i.v))pq.add(Pair(i.v, i.weight))
            }
            total += t.second
            visited.add(t.first)
        }
    }
    return total
}

fun main(){
    println(minCostConnectPoints(arrayOf(intArrayOf(3,12), intArrayOf(-2,5),
        intArrayOf(-4,1)
    )))
}