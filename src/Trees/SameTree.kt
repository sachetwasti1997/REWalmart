package Trees

class SameTree {
    data class TreeNode(val `val`: Int, val left: TreeNode?, val right: TreeNode?)
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null){
            return p == q
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.left?.`val` == q.left?.`val`
    }
}