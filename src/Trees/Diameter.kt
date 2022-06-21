package Trees

class Diameter {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    var ans = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        fun dfs(rootNew: TreeNode?): Int{
            if (rootNew == null)return 0
            val left = dfs(rootNew.left)
            val right = dfs(rootNew.right)
            val temp = 1 + Math.max(left, right)
            val res = Math.max(temp, 1 + left + right)
            ans = Math.max(ans, res)
            return temp
        }
        return ans - 1
    }
}