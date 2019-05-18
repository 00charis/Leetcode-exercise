//时间复杂度O(n)
//参考solution: https://leetcode.com/problems/valid-palindrome-ii/solution/
class Solution {
    public boolean isPalindrome(String s, int i, int j){
        for(int pi = i, pj = j; pi < pj; pi++, pj--){
            if(s.charAt(pi) != s.charAt(pj)){
                return false;
            }
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}