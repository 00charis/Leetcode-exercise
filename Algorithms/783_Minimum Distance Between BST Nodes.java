//这个题目用到了BST的in order 遍历
//in order的非递归方法用到了stack

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
    public int minDiffInBST(TreeNode root) {
        //为了方便处理空值，这里将pre, curr, ret全部都定义成null
        Integer pre = null;
        Integer curr = null;
        Integer ret = null;
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode currNode = root;

        //每一个外面的while循环处理一个结点
        while(currNode != null || !stack.isEmpty()) {
        		while(currNode != null) {
        			stack.push(currNode);
        			currNode = currNode.left;
        		}
        		currNode = stack.pop();
        		
        		pre = curr;
        		curr = currNode.val;
        		if(pre != null) {
        			ret = (ret == null ? curr - pre : Math.min(ret, curr - pre));
        		}
        		
        		currNode = currNode.right;
        }
        return ret;
    }
}