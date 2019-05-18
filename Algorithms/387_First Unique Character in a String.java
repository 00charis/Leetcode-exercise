//参考这个：https://leetcode.com/problems/first-unique-character-in-a-string/discuss/
class Solution {
    public int firstUniqChar(String s) {
        //使用这样的int数组可以节省空间
        int freq[] = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}