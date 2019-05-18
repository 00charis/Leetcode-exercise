// use an array to save numbers into different bucket whose index is the frequency
//bucket sort的time complexity 是O(n)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        //注意下面这个语句的写法，还有长度，可能所有的数都是一样的，所以要开这么长
        List<Integer> bucket[] = new List[nums.length + 1]; //k - frequency, value - numbers list
        
        for(int key : map.keySet()){
            int v = map.get(key);
            if(bucket[v] == null){
                bucket[v] = new ArrayList<>();
            }
            bucket[v].add(key);
        }
        
        List<Integer> ret = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && ret.size() < k; i--){
            if(bucket[i] != null){
                ret.addAll(bucket[i]);
            }
        }
        return ret;
    }
}



// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
// maxHeap的时间复杂度是O(nlogn)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        //maxheap是这样定义的
        //学会用这个类型：Map.Entry<Integer, Integer>
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        
        List<Integer> ret = new ArrayList<>();
        while(ret.size() < k){
            Map.Entry<Integer, Integer> curr = pq.poll();
            ret.add(curr.getKey());
        }
        
        return ret;
    }
}



// use treeMap. Use freqncy as the key so we can get all freqencies in order
// TreeMap的特性：The map is sorted according to the natural ordering of its keys
// This(TreeMap) implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        
        for(int key : map.keySet()){
            int value = map.get(key);
            if(treemap.get(value) == null){
                treemap.put(value, new ArrayList<>());
            }
            
            treemap.get(value).add(key);
        }
        
        List<Integer> ret = new ArrayList<>();
        while(ret.size() < k){
            Map.Entry<Integer, List<Integer>> curr = treemap.pollLastEntry();
            ret.addAll(curr.getValue());
        }
        
        return ret;
    }
}