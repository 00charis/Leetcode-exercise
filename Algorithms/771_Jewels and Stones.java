//用一个hashSet就好了
//非常简单
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hashSet = new HashSet<>();
        
        for(char c : J.toCharArray()) {
        		hashSet.add(c);
        }
        int ret = 0;
        for(char c : S.toCharArray()) {
        		if(hashSet.contains(c)) {
        			ret++;
        		}
        }
        return ret;
    }
}