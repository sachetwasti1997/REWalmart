package dp

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val set = HashSet(wordDict)
    fun dfsWordBreak(i: Int, j: Int): Boolean{
        if (i > j)return false
        if (set.contains(s.slice(IntRange(i, j))))return true
        var b = false
        for (k in i until j){
            b = b || dfsWordBreak(i, k) || dfsWordBreak(k+1, j)
        }
        return b
    }
    return dfsWordBreak(0, s.length - 1)
}

fun main(){
    println(wordBreak("applepenapple", listOf("apple", "pen")))
}
