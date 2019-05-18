//还是参考了这个模板：https://leetcode.com/problems/minimum-window-substring/discuss/26808
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] map = new char[128];
        
        //只需要返回最长的长度，所以不要用head变量记录最长的值开始的位置
        int begin = 0;
        int end = 0;
        int counter = 0;
        int d = 0;
        
        while(end < s.length()){
            if(map[s.charAt(end++)]++ == 0){
                counter++;
            }
            
            while(counter > 2){
                if(map[s.charAt(begin++)]-- == 1){
                    counter--;
                }
                
            }
            d = Math.max(d, end - begin);
            
        }
        return d;
    }
}