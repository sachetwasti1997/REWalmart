package graph

data class Node(var `val`: Int){
    val neighbors: ArrayList<Node?> = ArrayList()
}
