//这是一个dfs的方法，参考这里：https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027
//这个题目细节比较多，还是要好好理解
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    //从左往右遍历的时候，第一个括号可以多出来，第2个括号任何时候都不能多出来
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        //last_i前面的括号是匹配的
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;

            //从这里出循环，才会有正确的结果
            if (stack >= 0) continue;

            
            for (int j = last_j; j <= i; ++j){
                //这里和permutation去重复是一样的
                //last_i和last_j的含义只是说，dfs的时候，i和j从这里开始取值
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])){
                    String newStr = s.substring(0, j) + s.substring(j + 1, s.length());
                    remove(newStr, ans, i, j, par);
                }
            }
            //这里的return的意思是：送达下一层就都不管了，这一层就结束了。
            //把这个return和上面的for循环一起理解
            return;
        }
        //每个字符串的处理过程都是从左到右一次，从右到左一次
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}