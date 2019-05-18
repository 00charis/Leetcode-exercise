//用StringBuilder:
//append(int i) - Appends the string representation of the int argument to this sequence.
class Solution {
    public String countAndSay(int n) {
        StringBuilder pre = new StringBuilder("");
        StringBuilder curr = new StringBuilder("1");
        
        for(int t = 1; t < n; t++){
            pre = curr;
            curr = new StringBuilder();
            String preStr = pre.toString();
            
            char c = preStr.charAt(0);
            int count = 1;
            
            for(int i = 1; i < preStr.length(); i++){
                if(preStr.charAt(i) == c){
                    count++;
                }
                else{
                    curr.append(count).append(c);
                    c = preStr.charAt(i);
                    count = 1;
                }
            }
            //StringBuilder可以这样来做
            curr.append(count).append(c);
        }
        return curr.toString();
    }
}