package binSearch;

/**
 * If the leftmost element is smaller than the rightmost element in the portion that we are searching
 * then we have found the result
 * else if the middle value is greater then the leftmost value, then it is leftmost sorted portion
 * so we wan to search in right
 */
public class MinPivotRotatedSortedArr {
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, res = Integer.MAX_VALUE;
        while(l <= r){
            if(nums[l] < nums[r]){
                res = Integer.min(res, nums[l]);
                break;
            }
            int mid = (l+r)/2;
            res = Integer.min(res, nums[mid]);
            //leftmost sorted portion
            if(nums[mid] >= nums[l]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(findMin(new int[]{8,9,1,2,3,4,5,6,7}));
    }
}
