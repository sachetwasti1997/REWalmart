package graph

import java.util.InputMismatchException
import java.util.PriorityQueue

data class Edges(var nd: Int, var weght: Int)

fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val graph = HashMap<Int, ArrayList<Edges>>(n)
    val minDistanceMap = HashMap<Int, Int>(n)
    for (i in 1..n)minDistanceMap[i] = Int.MAX_VALUE
    for (i in times){
        if (graph[i[0]] == null){
            graph[i[0]] = ArrayList()
        }
        graph[i[0]]?.add(Edges(i[1], i[2]))
    }

        val pq = PriorityQueue<Pair<Int, Int>>(n){a,b -> a.second - b.second}
        pq.add(Pair(k, 0))
        minDistanceMap[k] = 0
        while (!pq.isEmpty()){
            val t = pq.poll()
            for (i in graph[t.first] ?: ArrayList()){
                println("${t.second + i.weght} ${i.nd}")
                println(minDistanceMap[i.nd])
                if (t.second + i.weght < (minDistanceMap[i.nd]!!)){
                    pq.add(Pair(i.nd, t.second + i.weght))
                    minDistanceMap[i.nd] = t.second + i.weght
                }
            }
        }
    var max = Int.MIN_VALUE;
    for (kt in minDistanceMap){
        if (max < kt.value)max = kt.value
    }
    return if (max == Int.MAX_VALUE) -1 else max
}

fun main(){
    val arr = arrayOf(
        intArrayOf(1,2,1),
    )
    println(networkDelayTime(arr, 2, 1))
}