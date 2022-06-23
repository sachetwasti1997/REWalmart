package intervie_prob;

import java.util.Arrays;

public class MergeSortedArr {

    int[] arr1;
    int[] arr2;

    public void swap(int i, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    public void mergeSortedArray(){
        int i = 0, j;
        while(i < arr1.length){
            j=0;
            if (arr1[i] > arr1[j]){
                swap(i, j);
            }
            while (j +1 < arr2.length && arr2[j] > arr2[j +1]){
                int temp = arr2[j];
                arr2[j] = arr2[j +1];
                arr2[j +1] = temp;
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        MergeSortedArr arr = new MergeSortedArr();
        arr.arr1 = new int[]{1, 4, 7, 8, 10};
        arr.arr2 = new int[]{2, 3, 9};
        arr.mergeSortedArray();
        System.out.println(Arrays.toString(arr.arr1));
        System.out.println(Arrays.toString(arr.arr2));
    }

}
