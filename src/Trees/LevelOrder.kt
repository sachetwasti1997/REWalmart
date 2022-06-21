package Trees

import java.util.*

class LevelOrder {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null)return arrayListOf()
        val q = LinkedList<TreeNode>()
        val res = mutableListOf<List<Int>>()
        res.add(listOf<Int>(root.`val`))
        q.add(root)
        var size = q.size
        while (!q.isEmpty()){
            val tempList = mutableListOf<Int>()
            for (i in 0 until size){
                val t = q.removeFirst()
                if (t.left != null){
                    q.add(t.left!!)
                    tempList.add(t.left!!.`val`)
                }
                if (t.right != null){
                    q.add(t.right!!)
                    tempList.add(t.right!!.`val`)
                }
            }
            if(tempList.size > 0)res.add(tempList)
            size = q.size
        }
        return res
    }
}