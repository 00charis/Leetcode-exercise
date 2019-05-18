//version1: DFS with memo
//我觉得这个像一个top down的dp
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()]; //注意memo的类型是Boolean
        return wordBreak(s, set, 0, memo);
    }
    public boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
        //这个操作和bottom up时候将dp = true是一个道理
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        //把这个输入的string分为一个word加一个递归解决的子问题。
        for (int end = start + 1; end <= s.length(); end++) {
            //和word pattern 类似，分割成前面一个单词，后面一个子问题的结构
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}

//version2: DP 参照solution的第4种方法
//这个是一个bottom up 的DP
//Time complexity O(n^2), Space complexity O(n)
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        //注意，这里是boolean，boolean是primitive type， Boolean是Class，boolean的默认初始化是false，Boolean的默认初始化是null
        boolean[] dp = new boolean[s.length() + 1];
        //dp几乎都是这么处理dp[0] = 1
        dp[0] = true; 
        //dp[i] 代表的意思是 （前面的i个字符是否可以word break）
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}