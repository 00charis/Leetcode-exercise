//二分查找题，自己会写
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            //下面有2大种情况，4小种情况
            if(nums[l] < nums[mid]){
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
        
        if(nums[l] == target){
            return l;
        }
        else if(nums[r] == target){
            return r;
        }
        else{
            return -1;
        }
    }
}