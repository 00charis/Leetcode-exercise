//brute force的做法
//非常简单
class Solution {
    private boolean isSelfDividing(int num) {
		for(char c : String.valueOf(num).toCharArray()) {//学习这个函数
			if(c == '0') {
				return false;
			}
			
			if(num % (c - '0') != 0) {
				return false;
			}
		}
		return true;
	}
	
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for(int i = left; i <= right; i++) {
        		if(isSelfDividing(i)) {
        			ret.add(i);
        		}
        		
        }
        return ret;
    }
}