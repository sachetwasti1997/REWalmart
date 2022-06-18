package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public void permute(List<List<Integer>> res, List<Integer> tempRes, int index,
                        int[] nums, Set<Integer> visited){
        if(index >= nums.length){
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for(int i: nums){
            if(!visited.contains(i)){
                visited.add(i);
                tempRes.add(i);
                permute(res, tempRes, index+1, nums, visited);
                tempRes.remove(tempRes.size()-1);
                visited.remove(i);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        permute(resList, tempList, 0, nums, visited);
        return resList;
    }
}
