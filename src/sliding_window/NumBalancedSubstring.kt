package sliding_window

    fun balancedSubstring(s: String): Int {
        var count = 0
        var i = 0
        var j = 0
        val set = HashMap<Char, Int>()
        val l = 'L'
        val r = 'R'
        while (i < s.length && j < s.length){
            if (set[s[j]] == null){
                if (set.size != 0){
                    if (s[j] == 'L')set[r] = set[r]?.minus(1) ?: 0
                    else if (s[j] == 'R')set[l] = set[l]?.minus(1) ?: 0
                }else{
                    set[s[j]] = 1
                }
                if (set[l] == 0){
                    i = j + 1
                    count ++
                    set.remove(l)
                }else if (set[r] == 0){
                    i = j + 1
                    count ++
                    set.remove(r)
                }
            }else{
                set[s[j]] = set[s[j]]?.plus(1) ?: 0
            }
            j++
        }
        println(count)
        return count
    }

fun main(){
    val s = "LLLLRRRLR"
    balancedSubstring(s);
}