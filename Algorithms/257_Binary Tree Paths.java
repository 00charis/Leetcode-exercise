//dfs
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
    private void dfs(List<String> ret, TreeNode root, String path){
        if(root.left == null && root.right == null){
            ret.add(path);
            return;
        }
        
        if(root.left != null){
            dfs(ret, root.left, path + "->" + root.left.val);
        }
        
        if(root.right != null){
            dfs(ret, root.right, path + "->" + root.right.val);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();//注意要创建一个具体类。
        if(root == null){
            return ret;
        }
        String path = new String(root.val + "");//注意，这里括号里面要加上"",这样括号里面的才可以用来初始化一个String
        dfs(ret, root, path);
        return ret;
    }
}