//现在基本可以秒。
//注意一些细节就可以了
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> ret = new LinkedList<>();
        
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            ret.add(intervals.get(i++));
        }
        
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        
        ret.add(newInterval);
        
        while(i < intervals.size()){
            ret.add(intervals.get(i++));
        }
        return ret;
        
    }
}