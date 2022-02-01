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
        if (map.size()==this.capacity){
            int i_min=0;
            int min=9999999;
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
// 1324
// 0123
//["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]