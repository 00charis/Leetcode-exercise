class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        list.add(val);
        if(contain == false){
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size() - 1);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if(contain == false){
            return false;
        }
        
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos); //有一个问题，这一行代码如果写到38行的位置会报错null pointer的错。
        //用一个例子理解这个事情，错误的原因是null调用了属于Set的函数remove
        //例子：insert 0, insert 1, insert 2, insert 3, insert 3, insert 3, remove 2, remove 3, remove 0
        //发生错误的情况就是在remove 3的时候会在Map里面删除2个，导致list和map不一致。
        if(pos < list.size() - 1){
            int lastNum = list.get(list.size() - 1);
            list.set(pos, lastNum);
            map.get(lastNum).remove(list.size() - 1);
            map.get(lastNum).add(pos);
        }
        //map.get(val).remove(pos);
        
        if(map.get(val).isEmpty()){
            map.remove(val);
        }
        list.remove(list.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */