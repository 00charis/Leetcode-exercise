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
    //注意函数的签名，返回的也是操作的这个结点
    public TreeNode deleteNode(TreeNode root, int key) {//root指向当前的根节点
        if(root == null){
            return root;
        }
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{//delete node
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                int newvalue = getMin(root.right);
                root.val = newvalue;
                root.right = deleteNode(root.right, newvalue);
            }
        }
        return root;
    }
    
    private int getMin(TreeNode p){
        while(p.left != null){
            p = p.left;
        }
        return p.val;
    }
}