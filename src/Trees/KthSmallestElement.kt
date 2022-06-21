package Trees

class KthSmallestElement {
    class Counter(var i: Int, var k: Int)
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val c = Counter(0, -1)
        fun inOrder(root: TreeNode?, k: Int){
            if(root == null)return
            inOrder(root.left, k)
            c.i++
            if(c.i == k)c.k = root.`val`
            inOrder(root.right, k)
        }
        return c.k
    }
}