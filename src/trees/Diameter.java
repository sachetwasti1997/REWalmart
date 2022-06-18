package trees;

public class Diameter {

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
    int ans = 0;
    public int diameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int maxHeight = 1 + Integer.max(left, right);
        int temp = Integer.max(1 + left + right, maxHeight);
        ans = Integer.max(ans, temp);
        return maxHeight;
    }

    public int diameterOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }
        diameter(root);
        return ans - 1;
    }
}
