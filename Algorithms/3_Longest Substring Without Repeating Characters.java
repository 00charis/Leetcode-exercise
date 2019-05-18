//这个题目仍然是参照了这个模板：https://leetcode.com/problems/minimum-window-substring/discuss/26808
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] map = new int[128];
        
        int begin = 0;
        int end = 0;
        int counter = 0; //counter是repeat的字符个数，或者说是种类
        int d = 0;
        
        while(end < n){
            if(map[s.charAt(end++)]++ == 1){
                counter++;
            }
            
            while(counter > 0){
                if(map[s.charAt(begin++)]-- == 2){
                    counter--;
                }
            }
            
            d = Math.max(d, end - begin);
        }
        return d;
    }
}