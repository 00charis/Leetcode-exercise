class StringIterator {
	String string  = null;
	int ptr;
	int num;//num of left ch
	char ch;
	
    public StringIterator(String compressedString) {
        string = compressedString;
        ptr = 0;
        num = 0;
        ch = ' ';
    }
    
    public char next() {
        if(!hasNext()) {
        		return ' ';
        }
        if(num == 0) {
        		ch = string.charAt(ptr++);
        		while(ptr < string.length() && Character.isDigit(string.charAt(ptr))) {
        			num = num * 10 + string.charAt(ptr++) - '0';
        		}
        }
        num--;
        return ch;
    }
    
    public boolean hasNext() {
        //第一个条件是可以往下找的意思
        //第二个条件是curr的还剩下
        return ptr != string.length() || num != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */