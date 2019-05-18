class Solution {
    //33是一个常用的进制转换的基数 radix。这是一个经验值
    public int strStr(String haystack, String needle) {
        if(needle == null) {
            return -1;
        }
        int m = needle.length();
        if(m == 0 && haystack != null) {
            return 0;
        }
        
        if(haystack == null) {
            return -1;
        }
        int n = haystack.length();
        if(n == 0) {
            return -1;
        }

        // mod could be any big integer
        // just make sure mod * 33 wont exceed max value of int.
        int mod = Integer.MAX_VALUE / 33;
        int hash_needle = 0;

        // 33 could be something else like 26 or whatever you want
        for (int i = 0; i < m; ++i) {
            hash_needle = (hash_needle * 33 + needle.charAt(i) - 'a') % mod;
            if (hash_needle < 0) {
                hash_needle += mod;
            }
        }

        int m33 = 1;
        for (int i = 0; i < m - 1; ++i) {
            m33 = m33 * 33 % mod;
        }

        int value = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= m) {
                value = (value - m33 * (haystack.charAt(i - m) - 'a')) % mod;
            }

            value = (value * 33 + haystack.charAt(i) - 'a') % mod;
            if (value < 0) {
                value += mod;
            }

            if (i >= m - 1 && value == hash_needle) {
                // you have to double check by directly compare the string
                if (needle.equals(haystack.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}



//v2：这是九章视频的做法。按照这个来做好理解
//Java, C++ 负整数的除法都是向零取整式整除。运算结果关于0对称和反号
//可以参考：http://cuihao.is-programmer.com/posts/38553.html
class Solution {
    private int BASE = 1000000;
    
    //Rabin Karp algorithm 也就是Rolling hash
    //参考九章算法班的Rabin Karp视频
    /**
     * 把字符串的比较变成整数的比较，要求hash的的结果是固定的，一个hash值可能对应很多的string
     * 最简单形式的hash function就是进制转换的形式，进制可以是比如31 （称作magic number，这是一个经验值）
     * 取模，比如1 * 10^6，这个mod的值越大，冲突的可能就越小
     * 如果hash的值一样，还是需要double check，做字符串的比较，做一个O(m)的比较
     * 加速的过程 => hash code不一样，那么原来的字符串一定不一样.
     * 整个的时间复杂度：O(n + m) 大部分情况比较hash code，double check的复杂度O(m)，可以认为hash code相等的次数为常数
     * @param source
     * @param target
     * @return
     */
    public int strStr(String source, String target) {
        //special condition: == NULL, size == 0
        if(source == null || target == null){
            return -1;
        }
        int m = target.length();
        int n = source.length();
        if(m == 0){
            return 0;
        }
        
        //31^ m
        int power = 1;
        for(int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        
        //target是小于BASE的
        //最左边的认为是高位
        int targetCode = 0;
        for(int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }
        
        int hashCode = 0;
        for(int i = 0; i < source.length(); i++) {
            //abc + d
            hashCode= (hashCode * 31 + source.charAt(i)) % BASE;
            //位数还不够
            if(i < m - 1) {
                continue;
            }
            //abcd - 1
            if(i >= m) {
                //始终记住，hashCode是BASE的余数数量级别
                hashCode= hashCode - (source.charAt(i - m) * power) % BASE;
                if(hashCode < 0) {//这里的条件判断是必要的，有一点不懂，注意一下
                    hashCode += BASE;
                }
            }
            
            //double check the string
            if(hashCode == targetCode) {
                //substring的第2个参数是不包括的结束位置
                if(source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        
        return -1;
        
    }

}