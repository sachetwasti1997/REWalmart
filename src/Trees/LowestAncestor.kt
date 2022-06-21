package Trees
data class TreeNode(val `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
class LowestAncestor {


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val list1 = ArrayList<TreeNode>()
        val list2 = ArrayList<TreeNode>()
        fun findPath(root: TreeNode?, node: TreeNode?, list: ArrayList<TreeNode>): Boolean{
            if (root == null) return false
            if (root.`val` == node?.`val`){
                list.add(node)
                return true
            }
            val left = findPath(root.left, node, list)
            val right = findPath(root.right, node, list)
            if (left || right){
                list.add(root)
                return true
            }
            return false
        }

        findPath(root, p, list1)
        findPath(root, q, list2)
        println(list1)
        println(list2)
        var i = 0
        var j = 0
        var res: TreeNode? = null
        while (i < list1.size && j < list2.size){
            if (list1[i].`val` == list2[j].`val`){
                res = list1[i]
                break
            }
            j++
            i++
        }
        return res
    }
}

fun main(){
    val v = LowestAncestor()
    val root = TreeNode(6)
    val left = TreeNode(2)
    val right = TreeNode(8)
    val left1 = TreeNode(4)
    root.left = left
    root.right = right
    left.left = left1
    println(v.lowestCommonAncestor(root, left1, left))
}