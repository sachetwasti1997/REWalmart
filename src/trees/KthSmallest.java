package trees;

public class KthSmallest {

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

    static class CountH{
        int val;
        int index = 0;
        CountH(int val){
            this.val = val;
        }
    }

    public void findElement(TreeNode root, int k, CountH c){
        if(root == null){
            return;
        }
        findElement(root.left, k, c);
        c.index ++;
        if(c.index == k){
            c.val = root.val;
            return;
        }
        findElement(root.right, k, c);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        CountH c = new CountH(0);
        findElement(root, k, c);
        return c.val;
    }

}
