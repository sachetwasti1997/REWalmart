package Trees

class GoodNodes {
    class count(var i: Int)
    fun goodNodes(root: TreeNode?): Int {
        val c = count(0)
        fun dfs(root: TreeNode?, parent: Int){
            if(root == null)return
            var greatest = parent
            if(parent < root.`val` || parent == Int.MIN_VALUE){
                greatest = root.`val`
                c.i++
            }
            dfs(root.left, greatest)
            dfs(root.right, greatest)
        }
        dfs(root, Int.MIN_VALUE)
        return c.i
    }
}