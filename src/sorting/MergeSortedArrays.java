package sorting;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[m+n];
        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                res[k] = nums1[i];
                i++;
            }else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m){
            res[k] = nums1[i];
            k++; i++;
        }
        while (j < n){
            res[k] = nums2[j];
            k++; j++;
        }
        for (i=0; i<k; i++){
            nums1[i] = res[i];
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 0, 0, 0};
        int[] nums = {2, 5, 6};
        merge(arr, 3, nums, 3);
        System.out.println(Arrays.toString(arr));
    }

}
