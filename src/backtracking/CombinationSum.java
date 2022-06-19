package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public void createSumList(List<Integer> tempResult, List<List<Integer>> resList,
                              int index, int sum, int[] nums){
        if(sum == 0){
            resList.add(new ArrayList<>(tempResult));
            return;
        }
        if(index >= nums.length || sum < 0){
            return;
        }
        tempResult.add(nums[index]);
        createSumList(tempResult, resList, index, sum - nums[index], nums);

        tempResult.remove(tempResult.size() - 1);
        createSumList(tempResult, resList, index+1, sum, nums);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> tempLst = new ArrayList<>();
        createSumList(tempLst, lst, 0, target, candidates);
        return lst;
    }

    public static void main(String[] args){
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
