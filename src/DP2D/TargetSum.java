package DP2D;

import java.util.*;

public class TargetSum {

    Map<String, Integer> dp;
    public int findTargetSum(int[] nums, int i, int target, int sum){
        if(i == nums.length){
            if(target == sum)return 1;
            return 0;
        }
        String key = i+" "+sum;
        if(dp.containsKey(key))return dp.get(key);
        dp.put(key, findTargetSum(nums, i+1, target, sum - nums[i]) + findTargetSum(nums, i+1, target, sum + nums[i]));
        return dp.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>(nums.length);
        return findTargetSum(nums, 0, target, 0);
    }

    public static void main(String[] args){
        //1,1,1,1,1
        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

}
