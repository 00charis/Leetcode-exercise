// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i : nums1) {
        		s1.add(i);
        }
        
        for(int i : nums2) {
        		if(s1.contains(i)) {
        			s2.add(i);
        		}
        }
        int[] ret = new int[s2.size()];
        int idx = 0;
        for(int i : s2) {
        		ret[idx++] = i;
        }
        return ret;
    }
}