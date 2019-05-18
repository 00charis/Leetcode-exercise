//参考solution: https://leetcode.com/problems/merge-intervals/solution/
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
    //这个用于比较的类要非常的熟悉
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval o1, Interval o2){//记住这个compare函数的签名，返回值是int
            return (o1.start < o2.start ? -1 : (o1.start == o2.start ? 0 : 1));
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        //这里要定义成LinkedList，因为LinkedList才有getLast
        LinkedList<Interval> ret = new LinkedList<>();
        
        for(int i = 0; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(i == 0 || curr.start > ret.getLast().end){//LinkedList的函数getLast()
                ret.add(curr);
            }
            else{
                ret.getLast().end = Math.max(ret.getLast().end, curr.end);
            }
        }
        return ret;
    }
}

//v2: TreeMap，即balanced binary tree的版本
//细节上，注意开闭区间
//时间复杂度log N,空间复杂度n
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
     TreeMap<Integer, Interval> tree;
    
    public List<Interval> merge(List<Interval> intervals) {
        tree = new TreeMap<>();
        for(Interval interval : intervals){
            addNum(interval);
        }
        
        return new ArrayList<>(tree.values());
    }
    
   
    public void addNum(Interval interval) {
        int s = interval.start;
        int e = interval.end;
        //TreeMap的函数要熟悉
        Integer l = tree.floorKey(s);
        Integer r = tree.ceilingKey(s); 
        
        int news = interval.start;
        int newe = interval.end;
        
        Integer curr = l;
        if(l == null || tree.get(l).end < news){
            curr = r;
        }
        //Java里面不可以在遍历的时候删除，必须要记录在一个list里，然后remove
        List<Integer> delete = new ArrayList<>();
        while(true){
            if(curr == null || curr > newe){
                break;
            }
            news = Math.min(curr, news);
            newe = Math.max(tree.get(curr).end, newe);
            delete.add(curr);
            curr = tree.higherKey(curr);
        }
        
        for(int i = 0; i < delete.size(); i++){
            tree.remove(delete.get(i));
        }
        
        tree.put(news, new Interval(news, newe));      
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
    
}