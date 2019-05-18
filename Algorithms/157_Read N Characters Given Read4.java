//字符是一个一个地写进去的，注意这个就可以了
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int sum = 0;
        boolean isFileEnd = false;
        
        while(sum < n && !isFileEnd){
            char[] temp = new char[4];
            int readNum = read4(temp);
            if(readNum < 4){
                isFileEnd = true;
            }
            
            int writeNum = Math.min(readNum, n - sum);
            for(int i = 0; i < writeNum; i++){
                buf[sum++] = temp[i];
            }
        }
        return sum;
    }
}