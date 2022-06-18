package trees;

public class GoodNodes {

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

    static class GoodNodeCounter{
        int count;
        GoodNodeCounter(int count){
            this.count = count;
        }
    }

    public void goodHelper(TreeNode root, int greatest, GoodNodeCounter count){
        if(root == null){
            return;
        }
        if(greatest <= root.val){
            count.count = 0;
            greatest = root.val;
        }
        goodHelper(root.left, greatest, count);
        goodHelper(root.right, greatest, count);
    }

    public int goodNodes(TreeNode root) {
        GoodNodeCounter count = new GoodNodeCounter(0);
        goodHelper(root, Integer.MIN_VALUE, count);
        return count.count;
    }

}













