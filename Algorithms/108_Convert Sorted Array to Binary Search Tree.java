/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//思路：divide and conquer
class Solution {
    private TreeNode helper(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
        		return null;
        }
        
        return helper(nums, 0, nums.length - 1);
    }
}