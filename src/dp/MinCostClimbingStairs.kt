package dp

fun minCostClimbingStairs(cost: IntArray): Int {
    val n = cost.size
    val dp = IntArray(n){-1}
    fun dfs(i: Int): Int{
        if (i >= n)return 0
        if (dp[i] != -1)return dp[i]
        dp[i] = Math.min(cost[i]+dfs(i+1), cost[i]+dfs(i+2))
        return dp[i]
    }
    return Math.min(dfs(0), dfs(1))
}

fun main(){
    println(minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))
}