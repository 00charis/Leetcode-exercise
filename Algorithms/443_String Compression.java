//我用的是和count and say一样的思路写的
//题目不难
class Solution {
    public int compress(char[] chars) {
		char c = chars[0];
		int count = 1;
		int pr = 1;
		int pw = 0;
		
		while(pr < chars.length) {
			if(chars[pr] == c) {
				pr++;
				count++;
			}
			else {
				chars[pw++] = c;
				if(count > 1) {
					for(char cc : Integer.toString(count).toCharArray()) {
						chars[pw++] = cc;
					}
				}
				
				
				c = chars[pr];
				pr++;
				count = 1;
			}
		}
		chars[pw++] = c;
		if(count > 1) {
			for(char cc : Integer.toString(count).toCharArray()) {
				chars[pw++] = cc;
			}
		}
		
		return pw;
    }
}