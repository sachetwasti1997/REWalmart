package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumHolder = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (!sumHolder.containsKey(target - nums[i])){
                sumHolder.put(nums[i], i);
            }else{
                int in = sumHolder.get(target - nums[i]);
                return new int[]{in, i};
            }
        }
        return new int[]{};
    }

}
