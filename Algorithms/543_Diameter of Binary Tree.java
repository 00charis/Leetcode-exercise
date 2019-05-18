//这个题的关键在于定义合理的辅助函数depth，返回节点的深度
//参考solution:https://leetcode.com/problems/diameter-of-binary-tree/solution/

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
    private int ans;//java里一般不在成员定义的时候初始化它
    
    private int depth(TreeNode root){
        //max distance when root is the LCA
        if(root == null){
            return 0;
        }
        
        int l = depth(root.left);
        int r = depth(root.right);
        int path = l + r;
        if(path > ans){
            ans = path;
        }
        return Math.max(l, r) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
        
    }
}