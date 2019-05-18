//这个题用recursive做，但是要注意越界的问题，所以helper函数的第2个和第3个参数是long类型的。要注意
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //这个函数的第2个和第3个函数时long类型的。
    private boolean helper(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val >= min && root.val <= max){
            if(helper(root.left, min, (long)root.val - 1) && helper(root.right, (long)root.val + 1, max)){
                return true;
            }
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}