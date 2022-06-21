package Trees

class BalancedBinTree {
    data class TreeNode(val `val`: Int, val left: TreeNode?, val right: TreeNode?)
    fun isBalanced(root: TreeNode?): Boolean {
        fun helper(rootNew: TreeNode?): Int{
            if (rootNew == null)return 0
            val left = helper(rootNew.left)
            val right = helper(rootNew.right)
            if (left == -1 || right == -1 || Math.abs(left - right) > 1)return -1
            return 1 + Math.max(left, right)
        }
        val res = helper(root)
        return res != -1
    }
}