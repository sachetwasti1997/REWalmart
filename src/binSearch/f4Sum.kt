package binSearch

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()
    val resList = mutableListOf<List<Int>>()
    for (i in 0..nums.size-2){
        if (i > 0 && nums[i-1] == nums[i])continue
        var start = i+1
        if (start > nums.size)break
        val res = nums[i] + nums[start]
        var end = nums.size - 1
        while (start < end){
            var mid = (start+end)/2
            if (res + nums[mid] > 0)start = mid + 1
            else if(res + nums[mid] < 0)end = mid - 1
            else{
                resList.add(listOf(res, nums[mid]))
                start++
                while (nums[start - 1] == nums[start] && start < end){
                    start++
                }
            }
        }
    }
    return resList
}

fun main(){
    println(fourSum(intArrayOf(-1,0,1,2,-1,-4), 0))
}