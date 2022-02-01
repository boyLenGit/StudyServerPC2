package meet;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;

public class m16_25 {
    public static void main(String[] arg){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}

class LRUCache {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int capacity;
    private int cnt = 0;
    private int cnt_grow = 0;
    private int[] stack;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public int get(int key) {
        // 读map不存在key的情况
        if (!map.containsKey(key)) return -1;
        // 存stack
        stack[cnt] = key;
        cnt = cnt==this.capacity ? cnt-this.capacity : cnt+1;
        // 读map
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.size()==this.capacity){
            cnt = cnt>=capacity ? 0 : cnt;
            map.remove(stack[cnt]);
            stack[cnt] = key;
        }else {
            stack[cnt_grow] = key;
            cnt_grow++;
        }
        map.put(key, value);
    }
}
// 1324
// 0123