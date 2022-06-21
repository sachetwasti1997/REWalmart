package DP2D

fun climbStairs(n: Int): Int {
    val dp = IntArray(n){-1}
    fun dfs(i: Int): Int{
        if (i == n)return 1
        if (i > n)return 0
        if (dp[i] != -1)return dp[i]
        dp[i] = dfs(i+1)+dfs(i+2)
        return dp[i]
    }

    return dfs(0)
}

fun main(){
    println(climbStairs(5))
}