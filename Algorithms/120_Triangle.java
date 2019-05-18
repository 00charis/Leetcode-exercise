//注意看triangle的结构，高度和最后一层的长度是一样的。
//算法：DP
//做法：从下往上算。只要保存一个一维的array
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[] dp = new int[level];
       
        for(int i = 0; i < level; i++) {
        		dp[i] = triangle.get(level - 1).get(i);
        }
        
        for(int i = level - 2; i >= 0; i--) {
        		for(int j = 0; j < triangle.get(i).size(); j++) {
                    //这里不会把有用的dp[j + 1]的值冲刷掉
        			dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        		}
        }
        
        return dp[0];
        
    }
}