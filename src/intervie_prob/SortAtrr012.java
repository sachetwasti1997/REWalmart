package intervie_prob;

import java.util.Arrays;

public class SortAtrr012 {
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sort(int[] arr){
        int low = 0, mid = 0 , high = arr.length - 1;
        while (mid <= high){
            if (arr[mid] == 0){
                swap(low, mid, arr);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            }else{
                swap(mid, high, arr);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr = {1, 0, 0, 1, 2, 0, 1, 2};
        SortAtrr012 s = new SortAtrr012();
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
