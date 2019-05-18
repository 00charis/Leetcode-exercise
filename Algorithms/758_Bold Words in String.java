//string的问题
//brute force的解法
class Solution {
   public String boldWords(String[] words, String S) {
        int len = S.length();
        boolean[] flag = new boolean[len];
        
        int i = 0;
        while(i < S.length()) {
                for(int j = 0; j < words.length; j++) {
                    String word = words[j];
                    if(S.substring(i).startsWith(word)) {//匹配到一个之后不可以break，因为这个不一定是最长的
                        for(int t = i ; t < i + word.length(); t++) {
                            flag[t] = true; //bold
                        }
                    }
                }
                i++;
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j < S.length(); j++) {
                if(flag[j] == true && (j == 0 || flag[j - 1] == false)) {
                    stringBuilder.append("<b>");
                }
                stringBuilder.append(S.charAt(j));
                if(flag[j] == true && (j == S.length() - 1 || flag[j + 1] == false)) {
                    stringBuilder.append("</b>");
                }
        }
        return stringBuilder.toString();
    }
}