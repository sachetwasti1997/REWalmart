package binSearch;

public class Search {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{-1,0,3,5,9,12};

    }

}
