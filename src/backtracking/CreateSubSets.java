package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CreateSubSets {
    public void createSubSets(List<List<Integer>> resList, List<Integer> tempList, int index, int[] nums){
        if(index == nums.length){
            resList.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[index]);
        createSubSets(resList, tempList, index + 1, nums);

        tempList.remove(tempList.size() - 1);
        createSubSets(resList, tempList, index + 1, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> tempSets = new ArrayList<>();
        createSubSets(subSets, tempSets, 0, nums);
        return subSets;
    }

    public static void main(String[] args){
        CreateSubSets c = new CreateSubSets();
        var t = c.subsets(new int[]{1, 2, 3});
        System.out.println(t);
    }
}
