//这个题目多想几遍就好了
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buf4 = new char[4];
    private int cnt4 = 0;
    private int ptr4 = 0;
    public int read(char[] buf, int n) {
        int cnt = 0;
        while(cnt < n){
            if(ptr4 == 0){
                cnt4 = read4(buf4);
                if(cnt4 == 0){
                    break;
                }
            }
            
            while(cnt < n && ptr4 < cnt4){
                buf[cnt++] = buf4[ptr4++];
            }
            
            if(ptr4 == cnt4){//这里很重要
                ptr4 = 0;
            }
        }
        return cnt;
    }
}