package dp

fun longestPalindrome(s: String): String {
    var iMax = 0
    var jMax = 0
    fun isPalindrome(i1: Int, j1:Int){
        var i = i1
        var j = j1
        while (i >= 0 && j < s.length && s[i] == s[j]){
            if (j - i + 1 > jMax - iMax + 1){
                iMax = i
                jMax = j
            }
            i--
            j++
        }
    }
    for (i in 0 until s.length-1){
        isPalindrome(i, i)
        isPalindrome(i, i+1)
    }
    return s.slice(IntRange(iMax, jMax))
}

fun main(){
    println(longestPalindrome("cbbd"))
}