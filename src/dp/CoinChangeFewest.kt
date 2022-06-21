package dp

fun coinChange(coins: IntArray, amount: Int): Int {
    val n = coins.size
    val dp = Array(coins.size+1){IntArray(amount+1){-1} }
    fun dfsFind(i: Int, am: Int): Int{
        if (am == 0)return 0
        if (i >= n || am < 0)return Int.MAX_VALUE-1
        if (dp[i][am] != -1)return dp[i][am]
        var res= 0
        if (coins[i] <=  amount){
            res = Math.min(1+dfsFind(i, am - coins[i]), dfsFind(i+1, am))
        }
        else {
            res = dfsFind(i+1, am)
        }
        dp[i][am] = res
        return res
    }
    return dfsFind(0, amount)
}

fun main(){
    println(coinChange(intArrayOf(1,2,5), 11))
}