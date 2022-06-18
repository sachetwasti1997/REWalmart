package binSearch;

/**
 * Search in left sorted portion and right sorted portion
 * check always if the element is in any of the sorted portion if it is move the pointer in the portion else
 * move it out
 */
public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[l]){
                if(nums[mid] < target || nums[l] > target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(nums[mid] > target || nums[r] < target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
