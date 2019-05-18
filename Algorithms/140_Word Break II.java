//Recursion with memoization
//我觉得这个也可以看作是top down的DP
public class Solution {
    public List<String> wordBreak(String s,  List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();
        return helper(s, set, 0, map);
    }
    //一个break的方式存成一个String，中间有“ ”
    //这是一个memo
    

    public List<String> helper(String s, Set<String> set, int start, Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        //这里的循环有点多，注意
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end))) {
                List<String> list = helper(s, set, end, map);//从这里来看top down的pruning做的比bottom up的好
                //因为要用到一个子问题才去计算它。
                for (String l : list) {//List可以这样来遍历
                    //这一句的细节很重要
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        //start的意思是从start这个index开始，向后有多少种的break方式
        map.put(start, res);
        return res;
    }
}

//bottom up 的DP会TLE，因为pruning不如top down的多。
//solution里面有写，bottom up的会TLE