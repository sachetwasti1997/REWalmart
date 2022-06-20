package dp;

import java.util.Arrays;

public class Jump {

    Boolean[] dp;

    public boolean jumpDfs(int[] nums, int i){
        if (i == nums.length - 1){
            return true;
        }
        if(dp[i] != null)return dp[i];
        int steps = nums[i];
        boolean t = false;
        while(steps > 0){
            t = t || jumpDfs(nums, i+steps);
            steps--;
        }
        return dp[i] = t;
    }

    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        Arrays.fill(dp, null);
        return jumpDfs(nums, 0);
    }

    public static void main(String[] args) {
        Jump j = new Jump();
        int[] num = {3,2,1,0,4};
        System.out.println(j.canJump(num));
    }

}
