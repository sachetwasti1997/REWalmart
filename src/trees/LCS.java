package trees;

import java.util.ArrayList;
import java.util.List;

public class LCS {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean findPath(TreeNode root, TreeNode node, List<TreeNode> lst){
        if(root == null){
            return false;
        }
        if(root.val == node.val){
            lst.add(root);
            return true;
        }
        boolean left = findPath(root.left, node, lst);
        boolean right = findPath(root.right, node, lst);
        if(left || right){
            lst.add(root);
            return true;
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var listp = new ArrayList<TreeNode>();
        var listq = new ArrayList<TreeNode>();
        findPath(root, p, listp);
        findPath(root, q, listq);
        int i = listp.size() - 1;
        int j = listq.size() - 1;
        TreeNode res = null;
        while(i >= 0 && j >= 0){
            if(listp.get(i).val == listq.get(j).val){
                res = listp.get(i);
            }
            if(listp.get(i).val != listq.get(j).val){
                return res;
            }
            i--;
            j--;
        }
        return res;
    }
}
