package trees;

public class TreeInPostOrder {
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
    int indx = 0;
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start >= inorder.length || end < 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[indx++]);
        int index = 0;
        for(int i = start; i <= end; i++ ){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, start, index - 1);
        root.right = helper(preorder, inorder, index+1, end);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1);
    }

    public static void main(String[] args){

    }
}
