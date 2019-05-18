//参考：https://discuss.leetcode.com/topic/7907/accepted-very-short-java-solution-no-additional-space
//这是一个in place的做法
class Solution {
    public boolean exist(char[][] board, String word) {
       int m = board.length;
       int n = board[0].length;
        
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               if(isExist(board, i, j, word, 0)){
                   return true;
               }
            }
       }
        
       return false;
    }
    
    public boolean isExist(char[][] board, int i, int j, String word, int start){
        if(start == word.length()){
            return true;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(start)){
            return false;
        }
        
        board[i][j] ^= 256;
        if(isExist(board, i - 1, j, word, start + 1)
          || isExist(board, i + 1, j, word, start + 1)
          || isExist(board, i, j - 1, word, start + 1)
          || isExist(board, i, j + 1, word, start + 1)){
            return true;
        }
        board[i][j] ^= 256;
        return false;
    }
}