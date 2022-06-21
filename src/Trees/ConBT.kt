package Trees

class ConBT {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var preIndx = 0
        fun consTree(start: Int, end: Int): TreeNode?{
            if(start > end)return null
            val root = TreeNode(preorder[preIndx++])
            var indx = -1
            for(k in inorder.indices){
                if(inorder[k] == root.`val`){
                    indx = k
                    break
                }
            }
            root.left = consTree(start, indx - 1)
            root.right = consTree(indx+1, end)
            return root
        }
        return consTree(0, inorder.size)
    }
}