package trees;

public class BalancedBinaryTree {

    private class TreeNode {
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
    public int isBalance(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = isBalance(root.left);
        int right = isBalance(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return 1 + Integer.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        int res = isBalance(root);
        return res != -1;
    }
}
