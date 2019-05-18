//参考这个：https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82553
//用的数据结构是TreeMap，但是思想是BST
//A Red-Black tree based NavigableMap implementation. TreeMap本来就是平衡二叉搜索树
//This implementation provides guaranteed log(n) time cost for the containsKey
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    //TreeMap的key是value即对应的interval的开始位置
    TreeMap<Integer, Interval> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        //如果区间已经存在就return，否则会把原来的记录冲刷了
        if(tree.containsKey(val)){
            return;
        } 
        //注意，这里返回值的类型必须是Integer，因为l和h有可能是null
        Integer l = tree.lowerKey(val); //greatest key strictly less than
        Integer h = tree.higherKey(val); //least key strictly greater than

        //下面的逻辑要理的非常清楚。
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {//这里，Integer也可以像int一样做正常的运算
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } 
        else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } 
        else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } 
        else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */