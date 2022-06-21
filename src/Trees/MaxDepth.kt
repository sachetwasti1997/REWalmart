package Trees

class MaxDepth {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun maxDepth(root: TreeNode?): Int {
        if (root == null)return 0
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
    }
}