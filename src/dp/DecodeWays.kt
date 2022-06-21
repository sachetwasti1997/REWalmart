package dp

fun numDecodings(s: String): Int {
    fun dfsDecode(i: Int):Int{
        if (i >= s.length)return 1
        if (s[i] == '0')return 0
        var res = dfsDecode(i+1)
        if (i+1 < s.length && (s[i] == '1' || s[i] == '2' && s[i+1] >= '0' && s[i+1] <= '6')){
            res += dfsDecode(i+2)
        }
        return res
    }
    return dfsDecode(0)
}

fun main(){
    println(numDecodings("06"))
}