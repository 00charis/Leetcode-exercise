//参考这个：https://leetcode.com/problems/divide-two-integers/discuss/13407
//时间复杂度认为是O(lgn ^ 2) 参考这里：https://leetcode.com/problems/divide-two-integers/discuss/13426
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        long dvd = Math.abs((long) dividend);//学习函数
        long dvs = Math.abs((long) divisor);
        int sign = (dividend < 0 ) ^ (divisor < 0) ? -1 : 1;
        
        int ret = 0;
        while(dvd >= dvs){
            long tmp = dvs; //这里temp也要定义为long 否则如果dvs是-MIN_VALUE，那么就不安全了
            int cnt = 1;
            while( (tmp << 1) < dvd){
                tmp <<= 1;
                cnt <<= 1;
            }
            ret += cnt;
            dvd -= tmp;
        }
        return ret * sign;
    }
}