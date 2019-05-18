//可以理解这是一个recursive solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    		return helper(nums, 0, nums.length - 1);
    }
    
    
    public TreeNode helper(int[] nums, int l, int r) {
    		if(r < l) {
    			return null;
    		}
    		
    		int maxidx = l;
    		
    		for(int i = l; i <= r; i++) {
    			if(nums[i] > nums[maxidx]) {
    				maxidx = i;
    			}
    		}
    	
    		TreeNode root = new TreeNode(nums[maxidx]);
    		
    		root.left = helper(nums, l, maxidx - 1);
    		root.right = helper(nums, maxidx + 1, r);
    	
    	
    		return root;
    }
}