package dp

fun countSubstrings(s: String): Int {
    var result = 0
    fun noOfSubs(i1: Int, j1: Int): Int{
        var res = 0
        var i = i1
        var j = j1
        while (i >= 0 && j < s.length && s[i] == s[j]){
            res ++
            i--
            j++
        }
        return res
    }
    for (i in 0 until s.length){
        result += noOfSubs(i, i) + noOfSubs(i, i+1)
    }
    return result
}

fun main(){
    println(countSubstrings("aaa"))
}