package Arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int [] resNum = new int[nums.length];
        Arrays.fill(resNum, 1);
        int preFix = 1;
        for (int i = 0; i < nums.length - 1; i++){
            preFix = preFix * nums[i];
            resNum[i+1] = preFix;
        }

        int postFix = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            resNum[i] = resNum[i] * postFix;
            postFix = postFix * nums[i];
        }
        System.out.println(Arrays.toString(resNum));
        return resNum;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

}
