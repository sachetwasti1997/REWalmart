package dp

class HouseRobber{
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n){-1}
        fun findDfsWays(i: Int):Int{
            if (i >= n)return 0
            if (dp[i] != -1)return dp[i]
            dp[i] = Math.max(nums[i]+findDfsWays(i+2), findDfsWays(i+1))
            return dp[i]
        }
        return findDfsWays(0)
    }
}

fun main(){
    val t = HouseRobber()
    println(t.rob(intArrayOf(2,7,9,3,1)))
}