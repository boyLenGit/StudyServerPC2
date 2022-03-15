package meet;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class m16_25 {
    public static void main(String[] arg){
        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));       // 返回  4

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

class LRUCache {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private HashMap<Integer, Integer> stack = new HashMap<>();
    private int capacity;
    private int cnt = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 读map不存在key的情况
        if (!map.containsKey(key)) return -1;
        // 存stack
        cnt++;
        stack.put(key, cnt);
        // 读map
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.size()==this.capacity & !map.containsKey(key)){
            int i_min=0;
            int min=Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> item: stack.entrySet()) {
                if (item.getValue()<min) {
                    i_min = item.getKey();
                    min = item.getValue();
                }
            }
            map.remove(i_min);
            stack.remove(i_min);
        }
        cnt++;
        map.put(key, value);
        stack.put(key, cnt);
    }
}

class LRUCache_leetcode {
    // 效率最高的双向链表算法
    // 定义一个双向链表
    static class Node {
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Node pre;
        Node next;
    }

    // 用来快速定位节点和记录节点数量
    private HashMap<Integer, Node> map;
    // 虚拟头节点
    private Node dummyFirst;
    // 虚拟尾节点
    private Node dummyLast;
    // LRU的容量
    private int capacity;

    /**
     * 初始化方法
     * @param capacity 指定缓存的容量
     */
    public LRUCache_leetcode(int capacity) {
        map = new HashMap<>(capacity);
        dummyFirst = new Node(-1, -1);
        dummyLast = new Node(-1, -1);
        // 建立虚拟头和虚拟尾节点的关系
        dummyFirst.next = dummyLast;
        dummyLast.pre = dummyFirst;
        this.capacity = capacity;
    }

    /**
     * 从缓存中获取数据
     * @param key 缓存的键
     * @return 缓存的值
     */
    public int get(int key) {
        // 如果map中没有这个key,证明没有命中缓存,直接返回-1即可
        if (!map.containsKey(key)) {
            return -1;
        }
        Node target = map.get(key);
        // 将命中缓存的节点移到链表的最末尾（虚拟尾节点前面）
        moveToTail(target, false);
        return target.value;
    }

    /**
     * 向缓存中写入数据
     * @param key 写入的键
     * @param value 写入的值
     */
    public void put(int key, int value) {
        // 如果这个map存在的话,只需要把这个节点移到链表的最末尾（虚拟尾节点前面）,并修改链表的值即可
        if (map.containsKey(key)) {
            moveToTail(map.get(key), false);
            map.get(key).value = value;
            return;
        }
        // 如果map不存在的话,需要在map和链表的最末尾（虚拟尾节点前面）新增这个节点,并且检查现在缓存超没超容量,如果超了的话需要删除链表的最前面的节点(虚拟头节点的后面)
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node, true);
        while (map.size() > capacity) {
            map.remove(dummyFirst.next.key);
            dummyFirst.next = dummyFirst.next.next;
            dummyFirst.next.pre = dummyFirst;
        }
    }

    /**
     * 将节点移动至链表的末尾，假末尾节点前面
     */
    private void moveToTail(Node node, boolean insert) {
        // 如果不是新增,而是修改,我们要维护原节点的pre和next节点的next和pre引用
        if (!insert) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 将节点移动到链表的最末尾（虚拟尾节点前面）
        node.next = dummyLast;
        node.pre = dummyLast.pre;
        dummyLast.pre = node;
        node.pre.next = node;
    }
}
// 1324
// 0123
//["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]