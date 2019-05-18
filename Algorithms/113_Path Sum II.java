//这是一个top down 的算法

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
    private void dfs(TreeNode p, int sum, List<List<Integer>> ret, List<Integer> list) {
		if(p == null) {
			return;
		}
		
		if(p.left == null && p.right == null) {
			if(p.val == sum) {
				list.add(p.val);
				ret.add(new ArrayList<>(list));
				list.remove(list.size() - 1);//add完了之后要remove
			}
			return;
		}
		
		list.add(p.val);
		dfs(p.left, sum - p.val, ret, list);
		dfs(p.right, sum - p.val, ret, list);
		list.remove(list.size() - 1);//add完了之后要remove
		
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>  ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, ret, list);
        
        return ret;
    }
}