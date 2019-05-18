//写了好多遍了，用backtracking
class Solution {
    private String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        //corner case的判断注意一下
        if(digits == null || digits.length() == 0){
            return ret;
        }
        
        String line = "";
        backtracking(digits, line, ret);
        return ret;
    }
    
    private void backtracking(String digits, String line, List<String> ret){
        if(line.length() == digits.length()){
            ret.add(line);
            return;
        }
        
        int idx = line.length();
        String word = dict[digits.charAt(idx) - '0'];
        for(char c : word.toCharArray()){
            line = line + c;
            backtracking(digits, line, ret);
            line = line.substring(0, line.length() - 1);
        }
        return;
    }
}