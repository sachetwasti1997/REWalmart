package greedy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int lastIndex = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        while(lastIndex < nums.length){
            if(sum < 0 && sum < nums[lastIndex]){
                sum = nums[lastIndex];
            }else{
                sum += nums[lastIndex];
            }
            maxSum = Integer.max(sum, maxSum);
            lastIndex++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray m = new MaxSubArray();
        System.out.println(m.maxSubArray(new int[]{-1, -2}));
    }

}
