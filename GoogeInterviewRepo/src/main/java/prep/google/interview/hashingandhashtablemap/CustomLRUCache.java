package prep.google.interview.hashingandhashtablemap;

import java.util.LinkedHashMap;
import java.util.Map;


public class CustomLRUCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    public static void main(String[] args) {
        CustomLRUCache<Integer, Integer> cache = CustomLRUCache.newInstance(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.put(3, 3);

        System.out.println(cache);
    }

    private CustomLRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K, V> CustomLRUCache<K, V> newInstance(int size) {
        return new CustomLRUCache<K, V>(size);
    }
}
