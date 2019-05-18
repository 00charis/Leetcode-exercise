//stack的方法。参考这里：https://leetcode.com/problems/binary-search-tree-iterator/discuss/52525
//时间空间复杂度：next() and hasNext() should run in average O(1) time and uses O(h) memory, 
//where h is the height of the tree.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode rootNode;
    Stack<TreeNode> st;
    
    //压栈直到下一个即将访问的点
    private void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        rootNode = root;
        st = new Stack<>();//Stack需要初始化
        pushAll(rootNode);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = st.pop();
        pushAll(curr.right);
        return curr.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */