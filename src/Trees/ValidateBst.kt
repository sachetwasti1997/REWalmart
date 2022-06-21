package Trees

class ValidateBst {
    fun isValidBST(root: TreeNode?): Boolean {
        fun checkValid(root: TreeNode?, min: Int, max: Int): Boolean{
            if(root == null)return true
            if(root.`val` >= max || root.`val` <= min)return false
            return checkValid(root.left, min, root.`val`) && checkValid(root.right, root.`val`, max)
        }
        return checkValid(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}