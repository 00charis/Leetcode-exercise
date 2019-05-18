//和33不一样的地方在于可能存在重复的element。
//所以多出来一个很tricky的处理，见while循环中第2个if语句
//可以参考discuss中的这个解法：https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28218
class Solution {
    public boolean search(int[] nums, int target) {
        boolean ret = false;
        if(nums.length == 0){
            return false;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            
            if(nums[mid] == target){
                return true;
            }
            //和33不一样的处理就在这里
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l++;
                r--;
            }
            
            else if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid;
                }
                else{
                    l = mid;
                }
            }
            else{
                if(target >= nums[mid] && target <= nums[r]){
                    l = mid;
                }
                else{
                    r = mid;
                }
            }
        }
        
        ret = nums[l] == target || nums[r] == target;
        return ret;
    }
}