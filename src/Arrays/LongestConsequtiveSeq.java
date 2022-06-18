package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSeq {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for(Integer i: nums)numSet.add(i);
        int maxLength = 0;
        for(Integer i: nums){
            if(!numSet.contains(i-1)){
                int length = 1;
                int temp = i;
                while(numSet.contains(temp+1)){
                    length++;
                    temp++;
                }
                maxLength = Integer.max(length, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
