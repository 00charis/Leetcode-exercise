//backtracking
//参考solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        String curr = "";
        backtracking(ret, curr, 0, 0, n);
        return ret;
    }
    
    private void backtracking(List<String> ret, String curr, int open, int close, int max){

        if(curr.length() == max * 2){
            //这里不需要new object了，因为输入的就是一个新的string
            ret.add(curr);
            return;
        }
        
        //注意2个条件的顺序
        if(open < max){
            //string + char和string + string都是可以的
            backtracking(ret, curr + '(', open + 1, close, max);
        }
        
        if(close < open){
            backtracking(ret, curr + ')', open, close + 1, max);
        }
    }
}