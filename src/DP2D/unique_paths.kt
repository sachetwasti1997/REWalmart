package DP2D

fun uniquePaths(m: Int, n: Int): Int {
    if(m <0 || n <0){
        return 0
    }
    if(m == 0 && n == 0){
        return 1
    }

    return uniquePaths(m-1, n) + uniquePaths(m, n-1)
}

fun main(){
    println(uniquePaths(2, 1))
}