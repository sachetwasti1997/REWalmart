package Trees

class MaxPathSum {

    fun maxPathSum(root: TreeNode?): Int {
        var res = Int.MIN_VALUE
        fun helper(root: TreeNode?): Int{
            if(root == null) return 0
            val left = helper(root.left)
            val right = helper(root.right)
            val temp = Math.max(root.`val` + Math.max(left, right), root.`val` + left+ right)
            val ans = Math.max(root.`val`, temp)
            res = Math.max(res, ans)
            return root.`val` + Math.max(left, right)
        }
        return res
    }
}