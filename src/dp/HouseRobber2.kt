package dp

fun rob(nums: IntArray): Int {
    val n = nums.size
    val dp = IntArray(n){-1}
    fun dfs(i: Int, n: Int): Int{
        if (i >= n)return 0
        if (dp[i] != -1)return dp[i]
        dp[i] = Math.max(nums[i] + dfs(i+2, n), dfs(i+1, n))
        return dp[i]
    }
    return Math.max(dfs(0, n-1), dfs(1, n))
}

fun main(){
    println(rob(intArrayOf(3)))
}