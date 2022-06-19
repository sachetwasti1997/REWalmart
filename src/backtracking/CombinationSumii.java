package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumii {
    public void combination(List<List<Integer>> resList, List<Integer> tempList, int index, int[] nums, int sum){
        if(sum == 0){
            resList.add(new ArrayList<>(tempList));
            return;
        }
        if(index >= nums.length || sum < 0){
            return;
        }
        tempList.add(nums[index]);
        combination(resList, tempList, index+1, nums, sum - nums[index]);
        tempList.remove(tempList.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        combination(resList, tempList, index+1, nums, sum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        combination(resList, tempList, 0, candidates, target);
        return resList;
    }

    public static void main(String[] args){
        int[] nums = {10,1,2,7,6,1,5};
        CombinationSumii c = new CombinationSumii();
        System.out.println(c.combinationSum2(nums, 8));
    }

}
