//下面是discuss最前的做法
//参考：https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977

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
    private TreeNode pre = null; //pre是前面一个处理的点。这个做法是从链表最下面的节点开始处理的，最下面节点的pre是null。
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        //链表的顺序从上到下是pre order，所以从下面到上面是右，左，中
        flatten(root.right);
        flatten(root.left);
        
        root.right = pre;
        root.left = null;
        pre = root;
    }
}