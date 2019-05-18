//解决办法就是parse line by line

//注意：这个题目的代码复杂程度取决于题目的要求。
//所以题目的test是什么样，代码写成什么样子就可以了
class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList<>();//ret
        
        for(String line : source) {
        		int i = 0;
        		char[] chars = line.toCharArray();
        		
        		if(!inBlock) newline = new StringBuilder();
        		while(i < line.length()) {
        			if(!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
        				inBlock = true;
        				i++;
        			}
        			else if(inBlock && i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
        				inBlock = false;
        				i++;
        			}
        			else if(!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/') {
        				break;
        			}
        			else if(!inBlock) {
        				newline.append(chars[i]);
        			}
        			i++;
        		}
        		
        		if(!inBlock && newline.length() > 0) {
        			ans.add(new String(newline));
        		}
        }
        return ans;
    }
	
}