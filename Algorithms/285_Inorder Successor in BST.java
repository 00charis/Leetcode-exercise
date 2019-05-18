/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//递归方法解的。
//代码记忆起来还是比较容易的
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        
        if(p.val >= root.val){
            return inorderSuccessor(root.right, p);
        }
        else{
            //这个注意理解，如果节点p是左子树最大的节点，那么它的后继是根节点
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}


//当做是一个followup
public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}