//这是一个比较tricky的方法
//参考一个discuss：

//对于这个方法的理解，下面有一个helloshen的图可以帮助理解。
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int p = 0;
        int ret = 0;
        for(int i = 0; i < intervals.length; i++){
            //开一个新的room
            if(start[i] < end[p]){
                ret++;
            }
            //用一个就的房间，就是以p的旧值结束的那儿房间
            else{
                p++;
            }
        }
        return ret;
    }
}