package dp;

import java.util.Arrays;

public class JumpGame2 {

    int[] t;
    public int jump(int[] nums, int i){
        if(i >= nums.length){
            return 1;
        }
        int res = Integer.MAX_VALUE;
        if (t[i] != -1){
            return t[i];
        }
        for (int t: nums){
            int steps = t;
            while (steps > 0){
                res = Integer.min(res, 1+jump(nums, i+steps));
                steps --;
            }
        }
        return t[i] = res;
    }
    public int jump(int[] nums) {
        t = new int[nums.length];
        if (nums.length == 1){
            return t[0] == 0? 0 : 1;
        }
        Arrays.fill(t, -1);
        return jump(nums, 0)-1;
    }

    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        System.out.println(j.jump(new int[]{2,3,0,1,4}));
    }
}
