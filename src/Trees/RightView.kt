package Trees

class RightView {
    fun rightSideView(root: TreeNode?): List<Int> {
        var maxLevel = -1
        val res = mutableListOf<Int>()
        fun dfs(root: TreeNode?, max: Int){
            if(root == null)return
            if(maxLevel < max){
                res.add(root.`val`)
                maxLevel = max
            }
            dfs(root.right, max+1)
            dfs(root.left, max+1)
        }
        dfs(root, 0)
        return res
    }
}