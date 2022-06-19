package graph

fun numDecodings(s: String): Int {
    val dp = Array(s.length){-1}
    fun findDecodings(i: Int): Int{
        if(i == s.length) return 1
        if(s[i] == '0') return 0
        if(dp[i] != -1)return dp[i]
        var res = findDecodings(i+1)
        if(i+1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i+1] >= '0' && s[i+1] <= '6'))){
            res += findDecodings(i+2)
        }
        dp[i] = res
        return dp[i]
    }
    return findDecodings(0)
}

fun main(){
    println(numDecodings("226"))
}