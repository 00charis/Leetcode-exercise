//参考这个答案的模板：https://leetcode.com/problems/minimum-window-substring/discuss/26808
//他的代码写的非常简洁
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        //map的意思是还剩下这么多要匹配
        for(char c : t.toCharArray()){
            map[c]++;
        }
        
        //head是全局最优值的开始位置
        int head = 0;
        int begin = 0;
        int end = 0;
        int d = Integer.MAX_VALUE; //d是全局最短长度 
        //counter的意思也是还剩下这么多要匹配
        int counter = t.length();
        
        while(end < s.length()){
            if(map[s.charAt(end++)]-- > 0){
                counter--;
            }
            
            while(counter == 0){//修改当前的全局最优值
                if(end - begin < d){
                    head = begin;
                    d = end - begin;
                }
                if(map[s.charAt(begin++)]++ == 0){
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}