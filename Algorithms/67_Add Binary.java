//这个题目要用到一个类StringBuilder，看具体地怎么来用。
class Solution {
    public String addBinary(String a, String b) {
        //这是初始化一个空的StringBuilder
        StringBuilder str = new StringBuilder();
        
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;
        
        while(pa >= 0 || pb >= 0 || carry == 1){
            int sum = carry;
            if(pa >= 0){
                sum += a.charAt(pa--) - '0';
            }
            
            if(pb >= 0){
                sum += b.charAt(pb--) - '0';
            }
            
            carry = sum / 2;
            //在后面添加用append
            str.append(sum % 2);
        }
        //可以reverse()，可以toString()
        return str.reverse().toString();
    }
}