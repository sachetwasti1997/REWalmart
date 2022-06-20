package sliding_window

import java.util.Arrays

fun mostRepeatedNumRange(s: String):IntArray{
    var i = 0
    var j = 0
    var iMax = 0
    var jMax = 0
    while (j < s.length){
        var recent = s[j]
        i = j
        while (j < s.length && s[j] == recent){
            j++
        }
        j--
        if (j - i + 1 > jMax - iMax + 1){
            iMax = i
            jMax = j
        }
        j++
    }
    return intArrayOf(iMax, jMax)
}

fun main(){
    var s = "1,1,2,2,2"
    val sb = StringBuilder()
    s.split(",").forEach {
        sb.append(it)
    }
    println(sb)
    val t = mostRepeatedNumRange(sb.toString())
    println(Arrays.toString(t))
}