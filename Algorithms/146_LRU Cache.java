//参考：https://www.jiuzhang.com/solution/lru-cache/
public class LRUCache {
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    //hashmap的key值是节点的key，value就是节点。
    //注意，hashmap里面存的是实实在在的节点
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //把head 和 pre用2个指针连起来
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if( !hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        //把节点拿出来这里需要2个操作
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void put(int key, int value) {
        // get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
        //这个比较难想
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        //这个时候要把最开始的节点删除了。因为key方便不下了
        //这个Java和C++的区别就是节点放点之后不需要delete
        if (hs.size() == capacity) {
            //hashmap的remove就是把这个key对应的pair删除了
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        //最近插入的放在末尾
        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}