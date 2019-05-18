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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
    		if(preStart > preEnd) {//如果是空节点的话，会出现preStart > preEnd, inStart > inEnd
                //用这2个条件的1个来判断就可以了
    			return null;
    		}
    		TreeNode root = new TreeNode(preorder[preStart]);
    		int inIdx = 0;
    		for(int i = inStart; i <= inEnd; i++) {
    			if(inorder[i] == root.val) {
    				inIdx = i;
    				break;
    			}
    		}
    		int leftsize = inIdx - inStart;
    		
    		root.left = helper(preStart + 1, preStart + leftsize, inStart, inIdx - 1, preorder, inorder);
    		root.right = helper(preStart + leftsize + 1, preEnd, inIdx + 1, inEnd, preorder, inorder);
    		return root;
    }
}