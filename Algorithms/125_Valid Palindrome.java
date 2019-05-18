//这个题目要用Character的几个函数
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){//这个函数！
                i++;
            }
                  
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            
            if(i < j){
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){//这个函数！
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
}