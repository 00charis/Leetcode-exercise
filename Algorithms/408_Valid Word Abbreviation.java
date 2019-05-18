//简单的模拟题
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while(i < word.length() && j < abbr.length()) {
                //匹配字符
        		if(word.charAt(i) == abbr.charAt(j)) {
        			i++;
        			j++;
        			continue;
        		}
        		
                //下面的情况都是匹配数字

        		if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
        			return false;
        		}
        		
        		int start = j;
        		while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
        			j++;
        		}
        		int num = Integer.valueOf(abbr.substring(start, j));
        		i += num;
        }
        
        return i == word.length() && j == abbr.length();
    }
}