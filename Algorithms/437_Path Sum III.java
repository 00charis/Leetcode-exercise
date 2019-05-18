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
	//定义了这样一个辅助函数
    private int pathSumFrom(TreeNode p, int sum) {//actually start from the node
    	//因为不要求路径到叶节点，所以在null节点处判断，
		if(p == null) {
			return 0;
		}
		return (p.val == sum ? 1 : 0) + pathSumFrom(p.left, sum - p.val) + pathSumFrom(p.right, sum - p.val);
	
	}
	
	public int pathSum(TreeNode root, int sum) {//begin from root or lower than root
        if(root == null) {
        		return 0;
        }
        
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        
    }
}