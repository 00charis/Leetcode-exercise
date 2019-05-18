//参考：https://leetcode.com/problems/flatten-2d-vector/discuss/67652
public class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        //注意：next是会把指针往下移动的，但是hasNext只做检测
        return j.next();//返回j当前所指向的值，同时j往下移动一个
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();//j.hasNext的意思是j现在指的位置有值
    }
}