//这个题目scan once的方法还是不容易想到的
//自己举一个例子：00110011 答案是6

class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int curr = 1;
        int ret = 0;
        
        for(int i = 1; i < s.length(); i++) {
        		if(s.charAt(i) == s.charAt(i - 1)) {
        			curr++;
        		}
        		else {
        			ret += Math.min(pre, curr);
        			pre = curr;
        			curr = 1;
        		}
        }
       ret += Math.min(pre, curr);
       return ret;
    }
}