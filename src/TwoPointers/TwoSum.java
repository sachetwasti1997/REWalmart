package TwoPointers;

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] > target){
                j --;
            }else if(numbers[i] + numbers[j] < target){
                i ++;
            }else{
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args){
        var t = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(t));
    }

}
