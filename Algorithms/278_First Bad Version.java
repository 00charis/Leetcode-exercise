
//二分查找，代码自己会写
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(isBadVersion(mid)){
                r = mid;
            }
            else{
                l = mid;//这里不能是l = mid + 1，否则会出现越界
            }
        }
        return isBadVersion(l) ? l : r;
    }
}