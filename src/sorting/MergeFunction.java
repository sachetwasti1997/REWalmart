package sorting;

import java.util.Arrays;

public class MergeFunction {
    public static void mergeParts(int[] arr, int low, int mid, int high){
        int left = mid - low + 1, right = high - mid;
        int [] leftArr = new int[left];
        int [] rightArr = new int[right];
        for (int i = 0; i < left; i++) leftArr[i] = arr[i];
        for (int i = 0; i < right; i++ )rightArr[i] = arr[i+ mid + 1];
        int i = 0, j = 0, k = 0;
        while (i < left && j < right){
            if (leftArr[i] < rightArr[j])arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i < left){
            arr[k++] = leftArr[i++];
        }
        while (j < right){
            arr[k++] = rightArr[j++];
        }
        System.out.println(Arrays.toString(leftArr)+"   "+Arrays.toString(rightArr)+"  "+Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int l, int r){
        if (r > l){
            int mid = l + (r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            mergeParts(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 11, 30};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
