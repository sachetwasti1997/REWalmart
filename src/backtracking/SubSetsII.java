package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubSetsII {

    public void makeSubSets(List<List<Integer>> resList, List<Integer> tempLst, int index, int[] nums){
        if(index >= nums.length){
            resList.add(new ArrayList<>(tempLst));
            return;
        }

        tempLst.add(nums[index]);
        makeSubSets(resList, tempLst, index+1, nums);
        tempLst.remove(tempLst.size() - 1);

        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        makeSubSets(resList, tempLst, index+1, nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        var lst = new ArrayList<Integer>();
        Arrays.sort(nums);
        makeSubSets(resList, lst, 0, nums);
        return resList;
    }

    public static void main(String[] args){
        SubSetsII sets = new SubSetsII();
        var t = sets.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(t);
    }

}
