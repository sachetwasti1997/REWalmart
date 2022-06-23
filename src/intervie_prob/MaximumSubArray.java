package intervie_prob;

public class MaximumSubArray {
    static int[] arr;

    public static void findMaxSubArray(){
        int j = 0, sum = 0, firstIndex = 0, length = 1, max = 0;
        while (j < arr.length){
            if (sum < 0 && sum < arr[j]){
                firstIndex = j;
                sum = arr[j];
                length = 1;
            }else{
                sum += arr[j];
            }
            if (max < sum){
                max = sum;
                length = Integer.max(length, j - firstIndex + 1);
            }
            j++;
        }
        System.out.println(length);
    }

    public static void main(String[] args) {
        arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        findMaxSubArray();
    }
}
