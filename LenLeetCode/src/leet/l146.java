package leet;

import java.util.HashMap;
import java.util.LinkedList;

public class l146 {
    public static void main(String[] arg){
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
    }
}

class LRUCache {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private LinkedList<Integer> used = new LinkedList<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        used.remove(key);
        used.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.size()==capacity){
            map.remove(used.get(0));
            used.remove(0);
        }
        map.put(key, value);
        used.add(key);
    }
}