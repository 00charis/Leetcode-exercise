
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){//可以这样遍历String的字符
            if(c == '('){
                st.push(')');
            }
            else if(c == '{'){
                st.push('}');
            }
            else if(c == '['){
                st.push(']');
            }
            else{
                if(st.isEmpty() || st.pop() != c){ //java里面pop是有返回值的。而且这实际是已经pop出来了
                    return false;
                }
            }
        }
        return st.isEmpty();//Stack用empty()和isEmpty()都是可以的
    }
}