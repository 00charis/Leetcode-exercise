//参考solution:https://leetcode.com/problems/longest-consecutive-sequence/solution/
//the numbers are stored in a HashSet (or Set, in Python) to allow O(1) lookups
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        int ret = 0;
        //set可以这样遍历，set里面的元素是无序的
        for(int begin : set){
            if(!set.contains(begin - 1)){
                int currMax = 1;
                int end = begin;
                while(set.contains(end + 1)){
                    end++;
                    currMax++;
                    
                }
                //在这个位置更新ret
                ret = Math.max(ret, currMax);
            }
        }
        
        return ret;
    }
}