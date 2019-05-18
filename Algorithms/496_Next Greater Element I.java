//用一个stack，先把nums2中的next greater element全部都算出来
//每处理到一个nums2中的数，都检查栈顶比它小的数，这个数是栈顶比它小的数的next greater
class Solution {
     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	      Stack<Integer> stack = new Stack<>();
	      Map<Integer, Integer> map = new HashMap<>();
	      
	      for(int i : nums2) {
	    	  	while(!stack.isEmpty() && i > stack.peek()) {
	    	  		map.put(stack.pop(), i);
	    	  	}
	    	  	stack.push(i);
	      }
	      
	      while(!stack.isEmpty()) {
	    	  		map.put(stack.pop(), -1);
	      }
	      
	      int[] ret = new int[nums1.length];
	      for(int i = 0; i < nums1.length; i++) {
	    	  	ret[i] = map.get(nums1[i]);
	      }
	      return ret;
	 }
}