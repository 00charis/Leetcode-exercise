//bfs,参考代码：https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76401
//这里的Map不可以用TreeMap,要用TreeMap，因为TreeMap的keySet是in ascending order的，TreeMap的不是
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
    private class Pair{
        TreeNode node;
        int col;
        Pair(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();//返回值这样初始化
        
        if(root == null){
            return ret;
        }
        
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            List<Integer> list = map.getOrDefault(curr.col, new ArrayList<>());
            list.add(curr.node.val);
            map.put(curr.col, list);
            
            if(curr.node.left != null){
                q.offer(new Pair(curr.node.left, curr.col - 1));
            }
            
            if(curr.node.right != null){
                q.offer(new Pair(curr.node.right, curr.col + 1));
            }
        }
        
        for(int k : map.keySet()){//可以用这种方式来遍历Integer类型的key
            ret.add(map.get(k));
        }
        
        return ret;
    }
}