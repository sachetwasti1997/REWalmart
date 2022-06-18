package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
     public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        var lst = new LinkedList<TreeNode>();
        lst.add(root);
        int size = lst.size();
        var list = new ArrayList<Integer>();
        list.add(root.val);
        var resList = new ArrayList<List<Integer>>();
        resList.add(list);
        while(!lst.isEmpty()){
            var tempList = new ArrayList<Integer>();
            for(int i = 0; i< size; i++){
                var temp = lst.removeFirst();
                if(temp.left != null) {
                    lst.add(temp.left);
                    tempList.add(temp.left.val);
                }
                if(temp.right != null) {
                    lst.add(temp.right);
                    tempList.add(temp.right.val);
                }
            }
            if(!tempList.isEmpty())resList.add(tempList);
            size = lst.size();
        }
        return resList;
    }
}
