//总结来说就是一个List和一个HashMap
class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map; //key: number, value: pos
    //学习Random这个类的用法
    private Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos = map.get(val);
        //这里的代码其实可以简洁一点
        if(pos == list.size() - 1){
            list.remove(list.size() - 1);
            map.remove(val);
        }
        else{
            int lastKey = list.get(list.size() - 1);
            list.set(pos, lastKey);//List中的元素要这样修改
            map.put(lastKey, pos);
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));//意思是在[0, list.size() - 1]中产生一个随机数
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */