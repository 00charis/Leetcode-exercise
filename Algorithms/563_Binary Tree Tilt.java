/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//用递归来做。
//思路就是：遍历每个点的时候做2件事情。累加tilt，求和
class Solution {
	private int ret;
    public int findTilt(TreeNode root) {
        ret = 0;
        getSum(root);
        return ret;
    }
    
    private int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = getSum(root.left);
        int right = getSum(root.right);
        ret += Math.abs(left - right);
        return left + right + root.val;
    }
}