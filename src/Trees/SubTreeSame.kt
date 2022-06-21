package Trees

class SubTreeSame {
    data class TreeNode(val `val`: Int, val left: TreeNode?, val right: TreeNode?)
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        fun sameTree(r: TreeNode?, root: TreeNode?): Boolean{
            if (r == null || root == null) return r == root
            val left = sameTree(r.left, root.left)
            val right = sameTree(r.right, root.right)
            return left && right && r.`val` == root.`val`
        }
        fun subTree(root: TreeNode?, subRoot: TreeNode?): Boolean{
            if (root == null)return false
            val left = subTree(root.left, subRoot)
            val right = subTree(root.right, subRoot)
            var tr = false
            if (root.`val` == subRoot?.`val`)tr = sameTree(root, subRoot)
            return left || right || tr
        }
        return subTree(root, subRoot)
    }
}