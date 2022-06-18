package trees;

import java.util.ArrayList;
import java.util.List;

public class RightSide {
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

    int maxLevel = -1;
    public void prepareRightView(TreeNode root, int level, List<Integer> resList){
        if(root == null){
            return;
        }
        if(maxLevel < level){
            resList.add(root.val);
            maxLevel = level;
        }
        prepareRightView(root.right, level + 1, resList);
        prepareRightView(root.left, level+1, resList);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        prepareRightView(root, 0, resList);
        return resList;
    }

}
