//题目的要求比较简单，
//用一下hashmap就可以解决
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < B.length; i++) {
        		map.put(B[i], i);
        }
        
        int len = A.length;
        int[] ret = new int[len];
        for(int i = 0; i < len; i++) {
        		ret[i] = map.get(A[i]);
        }
        
        return ret;
    }
}