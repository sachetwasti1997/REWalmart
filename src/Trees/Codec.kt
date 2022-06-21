package Trees

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val sb = ArrayList<String>()
        fun dfs(root: TreeNode?){
            if(root == null){
                sb.add("null")
                return
            }
            sb.add(root.`val`.toString())
            dfs(root.left)
            dfs(root.right)
        }
        dfs(root)
        return sb.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val vals = data.split(",")
        var i = 0
        fun dfs(): TreeNode?{
            if (vals[i] == "null"){
                i++
                return null
            }
            val root = TreeNode(vals[i].toInt())
            i++
            root.left = dfs()
            root.right = dfs()
            return root
        }
        return dfs()
    }
}