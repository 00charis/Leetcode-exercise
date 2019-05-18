//这个题会了，要从后面开始算。
//memo[i]的意思是：从i开始的后面所有char组成string有多少种decode的方法
//参考这个：https://leetcode.com/problems/decode-ways/discuss/30357
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int[] memo = new int[n + 1];
        //memo[n]初始化为1
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                continue;
            }
            //parseInt函数要会用
            memo[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? memo[i + 1] + memo[i + 2] : memo[i + 1];
        }
        
        return memo[0];
    }
}